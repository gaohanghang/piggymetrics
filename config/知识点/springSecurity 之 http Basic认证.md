# springSecurity 之 http Basic认证 

## 引言：

HTTP基础认证（BA）是一种简单的认证机制。当一个web客户端需要保护任何web资源的时候，服务器会发送一个带有401状态码（未授权）的HTTP回应，还有类似WWW-Authenticate: Basic realm=”realm here” 的 WWW-Authenticate HTTP头。而浏览器这时候就会弹出一个登录对话框，提示输入用户名和密码。

### 1. 修改配置
在spring boot项目中实现Spring Security进行http Basic认证非常简单，只需在配置文件中增加 .httpBasic(); 直接配置即可使用

```java
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UrlUserService urlUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(DATA_COLLECT_RAW_URL).permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .and()
                .logout()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

 auth.userDetailsService(urlUserService).passwordEncoder(new PasswordEncoder() {//此处为密码使用md5 进行加密

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
            }
        });
    }
}
```

### 2. 登录方式的变化

http Basic 实际上就是将我门的用户名和密码连接起来然后 使用base64进行加密，将加密后的密文放在http 的header 中进行验证。

```
帐号密码加密如下 (假设账号密码都为admin)

admin:admin    base64 加密后为     YWRtaW46YWRtaW4=
加密后的串放入 header 时应在拼结为 
Basic YWRtaW46YWRtaW4=       

注意：Basic  与密码串之间为一个空格  
```

postMan 请求如下：

![](http://ww4.sinaimg.cn/large/006tNc79ly1g35aodnsrbj316g0dijss.jpg)

### 3.在controller 中获取请求参数

由于登录是security 进行验证的，验证成功后会跳转到 “/login“ api，所以我门要定义自己login api

@AuthenticationPrincipal 注解是为了从security 中获取登录后的user 信息。 
登录成功后返回用户信息。 

当登出后也会进入”/login” api ，登出成功返回null

当登出后也会进入”/login” api ，登出成功返回null

```java
    @RequestMapping(value = "/login")
    @ResponseBody
    //用户名密码是用base64 加密 原文为 admin:admin 即 用户名:密码  内容是放在request.getHeader 的 "authorization" 中
    public Object login(@AuthenticationPrincipal User loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return null;
        }
        if (loginedUser != null) {
            return loginedUser;
        }
        return null;
    }
```

关于security 的Http Basic 验证到此就告一段落了。敬请期待。


