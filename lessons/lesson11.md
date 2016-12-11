# Онлайн проекта <a href="https://github.com/JavaWebinar/topjava08">Topjava</a>

#### Все патчи уже вчекинил в наш репозиторий и обновил <a href="http://topjava.herokuapp.com/">демо</a> приложение

### <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfjBtOHl2WXdKWEo5R0NkcENQdGt6b1d5VjFQYTFBVHU4VVhYY0dwbjZXc1U">Материалы занятия (скачать все патчи можно через Download папки patch)</a>


### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Правка и рефакторинг

#### Apply 11-0-1-fix-not-found.patch
> - Убрал уже ненужный `@ResponseStatus` в `NotFoundException` (он задается теперь в `ExceptionInfoHandler`)
> - В <a href="http://stackoverflow.com/a/22358422/548473">соответствии со спицификацией REST</a> для случая `not found` поменял `HttpStatus.NOT_FOUND` на `HttpStatus.UNPROCESSABLE_ENTITY`
 
#### Apply 11-0-2-other-fix.patch
- Фикс в `User/UserTo`, рефакторинг `inputField.tag` 
- Правка UTF-8 в редактировании профиля и регистрации (порядок `encodingFilter` и `springSecurityFilterChain` фильтров)
- Сделал <a href="https://dzone.com/articles/travis-ci-tutorial-java-projects">кэширование для сборки в travis-ci</a>

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW10

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFX2V5eHRsa09IWHc">HW10</a>
#### Apply 11-01-HW10-validation.patch
#### Apply 11-02-HW10-email-duplicate.patch

###  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYms4YUxEMHdxZHM">HW10 Optional: change locale</a>
#### Apply 11-03-HW10-change-locale.patch

>  еще вариант смены локали в lang.jsp вместо javascript: `href=${requestScope['javax.servlet.forward.request_uri']}?lang=..`

- <a href="http://forum.spring.io/forum/spring-projects/web/1077-differences-between-spring-message-and-fmt-message">spring-message vs fmt-message</a>
- <a href="http://pro-cod.ru/navbar-uroki-bootstrap-3.html">Bootstrap Navbar</a>

## Заключительное 11-е занятие

#### Apply 11-04-search-i18n.patch
- <a href="http://stackoverflow.com/questions/29929022/change-datatable-search-label/38133762#38133762">Добавил локализацию Search в datatable</a>
- Вынес общие части опций таблиц в `datatablesUtil.js` используя <a href="https://api.jquery.com/jquery.extend/#jQuery-extend-deep-target-object1-objectN">jQuery.extend()</a>

### Фильтруем JSON через @JsonView
#### Apply 11-05-JsonView.patch
- <a href="https://habrahabr.ru/post/307392/">@JsonView: фильтруем JSON</a>

## Защита от XSS (Cross Site Scripting)
Попробуйте до и после патча ввести в любое текстовое поле редактирования `<script>alert('XSS')</script>` и сохранить.
#### Apply 11-06-XSS.patch
- <a href="https://forum.antichat.ru/threads/20140/">Xss для новичков</a>
- <a href="https://habrahabr.ru/post/66057/">XSS глазами злоумышленника</a>
- <a href="http://stackoverflow.com/a/40644276/548473">Prevent people from doing XSS in Spring MVC</a>

###  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png)  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZkpVM19QWFBOQ2c">3. Деплой приложения в Heroku.</a>
#### Apply 11-07-heroku.patch

- В `AbstractUserController` добавилась защита от удаления-модификации `Admin/User` для профиля `HEROKU` (в `AbstractUserController` заинжектил `Environment` и сделал проверку `HEROKU` в активных профилях)
- Добавил тесты на запрет модификации `Admin/User` для профиля `HEROKU`
- <a href="http://habrahabr.ru/post/265591/">Деплой Java Spring приложения в PaaS-платформу Heroku</a>
```
Config Vars
  ERROR_PAGE_URL=...
  TOPJAVA_ROOT=/app

Datasources advanced
    ssl=true
    sslfactory=org.postgresql.ssl.NonValidatingFactory
```    

-  Ресурсы:
   -  <a href="https://www.heroku.com/">PaaS-платформа Heroku</a></h3>
   -  Конфигурирование приложения для запуска через <a href="https://devcenter.heroku.com/articles/java-webapp-runner">Tomcat-based Java Web</a>
   -  Конфигурирование <a href="https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-database_url-in-spring-with-xml-configuration">DataSource profile для Heroku</a>
   -  <a href="http://www.jetbrains.com/idea/webhelp/run-debug-configuration-heroku-deployment.html">Интерграция с IDEA</a>
   -  <a href="http://www.paasify.it/filter">Find your Platform as a Service</a>
   -  <a href="https://devcenter.heroku.com/articles/getting-started-with-java#set-up">Getting Started with Java on Heroku</a>
   -  <a href="https://devcenter.heroku.com/articles/keys">Managing Your SSH Keys</a>
   -  <a href="https://devcenter.heroku.com/articles/getting-started-with-spring-mvc-hibernate#deploy-your-application-to-heroku">Deploy your application to Heroku</a>
   -  <a href="http://www.ibm.com/developerworks/ru/library/j-javadev2-21/">Развертывание приложений Java с помощью PaaS от Heroku</a>
   -  <a href="http://www.infoq.com/articles/paas_comparison">A Java Developer’s Guide to PaaS</a>
   -  <a href="https://dzone.com/articles/simple-paas-comparison-guide">A Simple PaaS Comparison Guide (With the Java Dev in Mind)</a>
   -  <a href="http://www.ibm.com/developerworks/library/j-paasshootout/">Java PaaS shootout</a>

## Домашнее задание по проекту:
- **Задеплоить свое приложение в Heroku** 
- Сделать / обновить резюме (отдать на ревью мне или в группу)
  - <a href="https://github.com/JavaOPs/topjava/blob/master/cv.md">Составление резюме, подготовка к интервью, поиск работы</a>
  - <a href="http://goo.gl/forms/Oy5A7HNkWt">Заполнить форму соискателя "Разработчик Java"</a>.
- Выполнить <a href="https://github.com/JavaWebinar/topjava08/blob/doc/doc/graduation.md#graduation-project">Graduation project</a>
  - Добавил в него <a href="https://github.com/JavaWebinar/topjava08/blob/doc/doc/graduation.md#-Рекомендации">рекомендации</a>
  - Для участников с проверкой выпускной проект желательно сдать на ревью до 08.12. 
   
## Возможные доработки приложения:
-  Для редактирования паролей сделать отдельный интерфейс с запросом старого пароля и кнопку сброса пароля для администратора.
-  Добавление и удаление ролей для пользователей в админке.
-  Перевести UI на <a href="http://angular.ru/">angular.js</a> / <a href="https://vaadin.com/elements">Vaadin elements</a> /GWT /GXT /Vaadin / ZK/ [Ваш любимый фреймворк]..
-  Перевести проект на <a href="http://projects.spring.io/spring-boot/">Spring Boot</a>
-  Перевести шаблоны с JSP на <a href="http://www.thymeleaf.org/doc/articles/petclinic.html">Thymeleaf</a>
-  Сделать авторизацию в приложение по OAuth 2.0 (<a href="http://projects.spring.io/spring-security-oauth/">Spring Security OAuth</a>,
<a href="https://vk.com/dev/auth_mobile">VK auth</a>, <a href="https://developer.github.com/v3/oauth/">github oauth</a>, ...)
-  Сделать подтверждение регистрации пользователя по email c возможностью восстановления пароля.
-  Сделать отображение еды постранично, с поиском и сортировкой на стороне сервера.
-  Перевод проекта на https
-  Сделать desktop/mobile приложение, работающее по REST с нашим приложением.
-  <a href="http://stackoverflow.com/questions/16759264/spring-security-custom-authenticationexception-message/16759383#16759383">Локализация сообщений об ошибках</a>
-  <a href="http://spring.io/blog/2012/08/29/integrating-spring-mvc-with-jquery-for-validation-rules/">Показ ошибок в модальном окне редактирования таблицы так же, как и в JSP профиля</a>
-  <a href="http://www.mkyong.com/spring-security/spring-security-limit-login-attempts-example">Limit login attempts example</a>
-  Любая на ваше усмотрение.

**Делитесь своими доработками! Я их расшарю для всех**

### Ресурсы по Проекту
-  <a href="http://pro-cod.ru/uroki-bootstrap-3-0">Уроки Bootstrap 3</a>
-  <a herf="http://www.tutorialspoint.com/spring/index.htm">Spring at tutorialspoint</a>
-  <a href="http://www.codejava.net/frameworks/spring">Articles in Spring</a>
-  <a href="http://www.baeldung.com/learn-spring">Learn Spring on Baeldung</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/index.html">Spring Framework
            Reference Documentation</a>
-  <a href="http://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html/">Hibernate Reference Documentation</a>
-  <a href="http://java-course.ru/student/book2/">Java Course (книга 2)</a>
-  <a href="http://design-pattern.ru/">Справочник «Паттерны проектирования»</a>
-  <a href="http://martinfowler.com/eaaCatalog/">Catalog of Patterns of Enterprise Application Architecture</a>

## Пожалуйста <a href="http://goo.gl/forms/PtFcPqEV5n">ответьте на несколько вопросов по проекту</a>

-  В письме я вышлю ссылку для бесплатного повторного участия (первый урок topjava09 будет 08.12) и ссылку на добавление в группу Slak "Java Online Projects", кто еще не добавился.
-  Все материалы (в том числе и обновления в следующих проектах) останутся вам доступны в Google Drive.