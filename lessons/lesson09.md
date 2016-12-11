# Онлайн проекта <a href="https://github.com/JavaWebinar/topjava08">Topjava</a>

### <a href="https://drive.google.com/drive/folders/0B9Ye2auQ_NsFVWRGbEw1RjJrMjg">Материалы занятия (скачать все патчи можно через Download папки patch)</a>

- **Браузер кэширует javascript и css. Если изменения не работают, обновите приложение в браузере по Ctrl+F5**
- **При удалении файлов не забывайте делать clean: `mvn clean package`**

### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Правка и рефакторинг
#### Apply 9_0_1_fix
- `BaseEntity`: id надо доставать через getter, тк. у нас доступ к этом уполю через `AccessType.PROPERTY` и в ленивой обертке там может вернуться null.
- поправил имена `userMeal`-> `meal`
- вместо `DELETE FROM` <a href="http://stackoverflow.com/questions/13223820/postgresql-delete-all-content">сделал `TRUNCATE`</a>. 
  
#### Apply 9_0_2_fix
- Поправил стили `jquery.dataTables` на `dataTables.bootstrap` и добавил `dataTables.bootstrap..js` (вероятно для paging)
  - <a href="https://datatables.net/examples/styling/bootstrap.html">DataTables/Bootstrap 3 integration</a>
- Поправил в `users.jsp` локализацию

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW8

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFb0JKbElkT000amM">HW8</a>
> - Поправка к видео: в гриде bootstrap 12 колонок.
> - Все события сделал через `onlick`. Чтобы формы не сабмитились, заменил `type="submit"` на `type="button"`. 

- <a href="https://learn.javascript.ru/introduction-browser-events">Введение в браузерные события</a>

#### Apply 1-HW8.patch
- <a href="http://getbootstrap.com/css/#grid">Grid system</a>
- <a href="http://getbootstrap.com/css/#description">Bootstrap description</a>
- <a href="http://getbootstrap.com/css/#forms">Bootstrap forms</a>

###  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFV0VKY2FGbndGMTQ">HW8 Optional (enable/disable user)</a>
> - Вместо использования id и селекторов сделал обработчики `onclick`
> - Убрал  `init()`. При переводе таблицы на Ajax вместо него будет `createdRow`

#### Apply 2-HW8-enable-disable.patch

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMFJGLV9SaFBpQVE">HW8 Optional (new API)</a>
#### Apply 3_HW8_newApi.patch
> Новое API: поменялось как обновление таблицы, так и ее формат параметров.

-  <a href="https://datatables.net/upgrade/1.10-convert">Converting parameter names for 1.10</a>

## Занятие 9:

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYlRkc2NGRGVydk0">Spring Binding</a>
#### Apply 4_binding.patch

>  Move `ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY` to `ru.javawebinar.topjava.util.UserUtil`

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFd2ZvcS1pSjdMQlU">Реализация update</a>
#### Apply 5_update.patch

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFLXp5MTFDMEY5WFE">Spring Validation</a>
#### Apply 6_validation.patch
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-beanvalidation">Spring Validation.</a>
-  <a href="http://beanvalidation.org/">Bean Validation</a>
-  <a href="https://spring.io/blog/2012/08/29/integrating-spring-mvc-with-jquery-for-validation-rules">Валидация формы по AJAX.</a>
-  <a href="http://stackoverflow.com/questions/14730329/jpa-2-0-exception-to-use-javax-validation-package-in-jpa-2-0#answer-17142416">JSR-303, 349</a>
- <a href="https://dzone.com/articles/spring-31-valid-requestbody">@Valid @RequestBody + Error handling</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcW1qeTVFdS1BdHM">Перевод DataTables на Ajax</a>
#### Apply 7-datatable-via-ajax.patch
-  <a href="http://legacy.datatables.net/usage/options">DataTables Options</a>

#### Apply 8-js-i18n.patch
> - Добавил простую интернационализацию в JavaScript. 
>   - на стороне сервера формируется `i18n` JavaScript массив с значениями, который затем используется для интернационализации в браузере
>   - в модальном окне заголовок подменяется через `$('#modalTitle').html(..title)`
   
- <a href="http://stackoverflow.com/a/6242840/548473">JavaScript internationalization</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 8.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUmhUTms1WnhTeHc">Форма логина / логаут.</a>
#### Apply 9-min-form-login.patch

> Добавил в патч функциональность logout

-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#ns-minimal">Минимальный form-login</a>
-  <a href="http://docs.spring.io/spring-security/site/migrate/current/3-to-4/html5/migrate-3-to-4-xml.html#m3to4-xmlnamespace-form-login">Migrating &lt;form-login&gt;</a>
- Вопросы:
  - Почему при логине как admin еда отдаются для user?
  - Почему при логине как user не отображается список пользователей?
  - Почему еда не редактируется?
  
#### Apply 10-jsp-form-login.patch
-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#ns-form-and-basic">Собственный form-login</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 9. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYTA4aVN4bWxzbEU">Реализация собственного провайдера авторизации.</a>
#### Apply 11_auth_via_user_service.patch

-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#userdetailsservice-implementations">UserDetailsService Implementations</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 10.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFT2Qya2V4N0kzWWM">Принцип работы Spring Security. Проксирование.</a>
-  <a href="http://www.spring-source.ru/articles.php?type=manual&theme=articles&docs=article_07">Принцип работы Spring Security</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/aop.html#aop-proxying">Типы проксирования</a>
-  <a href="http://samolisov.blogspot.ru/2010/04/proxy-java.html">Dynamic Proxy API</a>
-  <a href="http://stackoverflow.com/questions/13977093/how-to-use-jparepositories-with-proxy-target-class-true/25543659#25543659">Конфликт проксирования Data Repository</a>
-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#filter-stack">Security фильтры</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 11. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFU3hMR0o4eGNoUmc">Spring Security Test</a>
#### Apply 12-spring-security-test.patch

> В RootControllerTest сделал имитацию авторизации через `TestUtil.authorize`

-  <a href="http://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#test">Spring Security Test</a></h3>
-  <a href="http://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#test-mockmvc">Интеграция со Spring MVC Test</a>
-  <a href="http://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#testing-http-basic-authentication">HttpBasic авторизация</a>
-  <a href="http://habrahabr.ru/post/171911/">Тестирование контроллеров с помощью MockMvc (без spring-security-test)</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 12. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUzNFanF6MGZGNHc">Cookie. Session.</a>
-  <a href="https://ru.wikipedia.org/wiki/HTTP_cookie">HTTP cookie</a></h3>
-  <a href="http://stackoverflow.com/questions/595872/under-what-conditions-is-a-jsessionid-created">Under what conditions is a JSESSIONID created?</a>
-  <a href="http://halyph.blogspot.ru/2014/08/how-to-disable-tomcat-session.html">Tomcat Session Serialization</a>

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы

>  В куки попадает обычная строка JSESSIONID. Куда сериалиуется обьект User?

Для хранения сосотяния сессии (например корзины покупателя) в Servlet API есть механизм хранения объектов сессии (грубо- мультимапмапа, которая достается из хранилища по ключу). При создании сессии на стороне сервера (через `request.getSession`) создается кука `JSESSIONID`, которая пеердается между клиентом и сервером и является ключом в хранилище объектов сессий. См. <a href="http://javatutor.net/books/tiej/servlets#_Toc39472970">обработка сессий с помощью сервлетов</a>

> В `login.jsp` есть форма `&lt;form:form action="spring_security_check" ..&gt; Где такой url используется?

Это стандартный url для авторизации в spring-security. Он его и обрабатывает.

> Если не пользовать js, а писать UI на JSP, сообщения между ui и сервером будут в формате json? Это же будет JSON API?

Есть данные, которые передаются между клиентом и сервером в формате json, есть стандартизированный формат url для ресурсов - <a href="https://ru.wikipedia.org/wiki/REST">архитектурный стиль REST</a>. И есть отрисовка UI: JSP, Javascript фреймворк, Thymleaf и пр. Не надо эти вещи путать между собой. 

> По умолчанию спринг работает с `UserDetailsService`, который должен возвращать `UserDetails`. Но мы не хотим стандартные, мы хотим свои, поэтому просто наследуем наши `UserServiceImpl` и `AuthorizedUser` от соответствующих интерфейсов и реализуем недостающие методы, которые spring security и будет использовать?

Сервис аутентификации конфигурится в `spring-security.xml` `<authentication-manager>` и должен реализовывать интерфейс `UserDetailsService`. В spring-security есть его стандартные реализации, которые использовались до нашей кастомной `UserServiceImpl`, например `<jdbc-user-service` использует реализацию `JdbcUserDetailsManager`

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW9

- Реализовать для meal Binding/ Update/ Validation. Проверить работу при пустом значении Calories.
- Перевести meals.jsp на работу по ajax. Стиль строки таблицы сделать в зависимости от exceeded.
- Починить meals тесты

#### Optional
- Подключить datetime-picker
  - <a href="http://xdsoft.net/jqplugins/datetimepicker/">DateTimePicker jQuery plugin</a>
  - Еще есть <a href="https://eonasdan.github.io/bootstrap-datetimepicker/">Bootstrap 3 Datepicker</a>

## ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Проверка в HW09
- Проверьте, что при добавлении и редактировании пользователя и еды у вас корректно отображаются заголовки модального окна:
"Добавить/Редактировать еду/пользователя"
- Попробуйте не дублировать
```
<c:forEach var='key' ...
i18n['${key}'] = ...
```
- Для подключения css и js datetimepicker-а посмотрите в его jar (или поищите в проекте по Ctrl+Shift+N: `datetimepicker`)
