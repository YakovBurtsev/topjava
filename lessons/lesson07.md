# Онлайн проекта <a href="https://github.com/JavaWebinar/topjava08">Topjava</a>

### <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfjVnUVhINEg0d09Nb3JsY2ZZZmpsSWp3bzdHMkpKMmtPTlpjckxyVzg0SWc">Материалы занятия (скачать все патчи можно через Download папки patch)</a>

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW6

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbUhMdTdESkpFekE">HW6</a>
#### Apply 01-HW6-fix-tests.patch
#### Apply 02-HW6-jsp-i18n.patch
> локализовал весь контент

-  <a href="http://stackoverflow.com/questions/10327390/how-should-i-get-root-folder-path-in-jsp-page">Root path in JSP</a>
   
#### Apply 03-HW6-meals.patch
#### Apply 04-HW6-fix-relative-url-utf8.patch
   -  <a href="http://stackoverflow.com/questions/4764405/how-to-use-relative-paths-without-including-the-context-root-name">Relative paths in JSP</a>
   -  <a href="http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html#mvc-redirecting-redirect-prefix">Spring redirect: prefix</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFaXViWkkwYkF0eW8">HW6 Optional</a>
#### Apply 05-HW6-optional-add-role.patch
   - <a href="http://www.mkyong.com/hibernate/hibernate-fetching-strategies-examples/">Hibernate - fetching strategies examples</a>
   - <a href="https://docs.oracle.com/javaee/7/tutorial/persistence-entitygraphs002.htm">Using Named Entity Graphs</a>

> Изменения в проекте: ввел `EntityGraph` для еды и `@BatchSize` для ролей (при этом `DISTINCT` уже не нужен). Всегда проверяйте по логам, как работают запросы- иногда совсем не так, как в документации.

#### Apply 06-HW6-optional-jdbc.patch
   -  <a href="http://easy-code.ru/lesson/local-anonymous-nested-classes-java">Локальные классы</a>

> Еще интересные jdbc реализации:
> - в `getAll()` делать запрос с `LEFT JOIN` и `ResultSetExtractor`  
> - доставать агрегированные роли и делать им `split(",")`:
```
SELECT u.*, string_agg(ur.role, ',') AS roles FROM users u JOIN user_roles ur ... GROUP BY u.id
```

## Занятие 7:
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTEtkSldKUnE4VkE">Auto generate DDL.</a>
#### Apply 07-generate-ddl.patch

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQXhBN1pqa3FyOUE">Тестирование Spring MVC</a>
#### Apply 08-controller-test.patch

> - В `MockMvc` добавился `CharacterEncodingFilter`
> - Закомментировали генерацию DDL 

-  <a href="http://hamcrest.org/JavaHamcrest/">Hamcrest</a>
-  <a href="http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/">Unit Testing of Spring MVC Controllers</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWE5oSmJFZGZBRlE">REST контроллеры</a>
#### Apply 09-rest-controller.patch
> В Spring 4.3 ввели новые аннотации `@Get/Post/...Mapping` (сокращенный вариант `@RequestMapping`)
 
-  <a href="https://ru.wikipedia.org/wiki/JSON">JSON (JavaScript Object Notation</a>
-  <a href="https://spring.io/understanding/rest">Understanding REST</a>
-  <a href="http://www.infoq.com/articles/springmvc_jsx-rs">JAX-RS vs Spring MVC</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping">Request mapping</a>
-  Ресурсы:
   - <a href="http://habrahabr.ru/post/144011/">RESTful API для сервера – делаем правильно (Часть 1)</a>
   - <a href="http://habrahabr.ru/post/144259/">RESTful API для сервера – делаем правильно (Часть 2)</a>
   - <a href="https://www.youtube.com/playlist?list=PLtDz82bWepMPLi_e9YbatLRpm0z4uOs_U">И. Головач. RestAPI</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQmNwOXJ6RFk4M1U">Тестирование REST контроллеров. Jackson.</a>
#### Apply 10-rest-test-jackson.patch
-  https://github.com/FasterXML/jackson-databind

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNWEyVGJIU2JMTFE">jackson-datatype-hibernate. Тестирование через матчеры.</a>
    
#### Apply 11-jackson-hibernate.patch
-  <a href="https://www.sghill.net/how-do-i-write-a-jackson-json-serializer-deserializer.html">Jackson JSON Serializer & Deserializer</a>
-  Сериализация hibernate lazy-loading с помощью <a href="https://github.com/FasterXML/jackson-datatype-hibernate">jackson-datatype-hibernate</a>

#### Apply 12-jackson-jsr310.patch
>  Переводим сериализацию-десериализацию LocalDateTime на jsr310 и стандартный формат ISO-8601

-  <a href="http://stackoverflow.com/questions/28802544/java-8-localdate-jackson-format#28803634">jackson-datatype-jsr310</a>

#### Apply 13-test-with-matcher.patch
-  <a href="http://habrahabr.ru/post/259055/">Тестируем Spring Rest контроллеры</a>: проверка JSON-содержимого ответа через собственный ResultMatcher

> - Матчеры у нас были зарефакторенны: введен `Wrapper` и `Comparator`. Устройство матчеров может показаться сложным. Как это работает можно разбираться, только если самому на их основе что-то имплементировать. Мы используем Spring MVC и Hibernate не заботясь о том, насколько они сложные в реализации. Использование матчеров также достаточно просто.
> - При запуске из Maven тесты начинают зависеть от порядка запуска.  В этот раз не проходил тест `ProfileRestControllerTest.testGet`, который шел за `AdminRestControllerTest.testUpdate`: после отката транзакции по `@Transactional` Hibernate кэш не восстанавливал роль для USER (доставалась null). 
Добавил очистку кэша Hibernate в `AbstractControllerTest.setUp`.
> - Присваивание юзеру ролей сделал через копирование

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 8. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVXNmOUdBbUxxWVU">Тестирование через SoapUi. UTF-8</a>
#### Apply 14-soapui-utf8-converter.patch
- Решение проблемы с UTF-8 в `StringHttpMessageConverter`
- Инструменты тестирования REST:
  - <a href="http://www.soapui.org/">SoapUi</a>
  - <a href="http://rus-linux.net/lib.php?name=/MyLDP/internet/curlrus.html">Написание HTTP-запросов с помощью Curl</a>
(для Windows можно использовать Git Bash)
  - <a href="https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop">Postman</a>
  - <a href="https://www.jetbrains.com/help/idea/rest-client-tool-window.html">IDEA: Tools->Test RESTful Web Service</a>

>  - Импортировать проект в SoapUi из config\Topjava-soapui-project.xml
>  - Response смотреть в формате JSON.
   
-  Проверка UTF-8: <a href="http://localhost:8080/topjava/rest/profile/text">http://localhost:8080/topjava/rest/profile/text</a>
-  <a href="http://forum.spring.io/forum/spring-projects/web/74209-responsebody-and-utf-8">ResponseBody and UTF-8</a>

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы
> При выполнении тестов через MockMvc никаких изменений на базе не видно, почему оно не сохраняет?

`AbstractControllerTest` аннотируется `@Transactional` - это означает, что тесты идут в транзакции и после каждого теста JUnit делает rollback базы.

> После патча 7_13 тест ProfileRestControllerTest.testGet нам оставляет поле meals:null хотя мы задали чтоб не сериализовались null поля.
  Почему его оставляет сериализатор? (конечно если выставим NON_EMPTY то уберет)

Там lazy коллекция, а не null. Думаю, что Hibernate5Module уже после логики NOT_NULL (JacksonObjectMapper) ее обнуляет.

>  В чем заключается расширение функциональности hamcrest в нашем тесте, что нам пришлось его отдельно от JUnit прописывать?

hamcrest-all используется в проверках `RootControllerTest`: `org.hamcrest.Matchers.*`

>  Jackson мы просто подключаем в помнике и спринг будет с ним работать без любых других настроек?

Да, Spring смотрит в classpath и если видит там Jackson, то подключает интеграцию с ним

>  Где-то слышал, что любой ресурс по REST должен однозначно идентифицироватьcя через url, без параметров. Правильно ли задавать URL для фильтрации в виде `http://localhost/topjava/rest/meals/filter/{startDate}/{startTime}/{endDate}/{endTime}` ?

Так делают, только при отношении <a href="https://ru.wikipedia.org/wiki/Диаграмма_классов#.D0.90.D0.B3.D1.80.D0.B5.D0.B3.D0.B0.D1.86.D0.B8.D1.8F">агрегация</a>, например если давать админу право смотреть еду любого юзера, URL мог бы быть похож на `http://localhost/topjava/rest/users/{userId}/meals/{mealId}`. В случае критериев, поиска или странчных данных они передаются как параметр.

> Что означает конструкция в `JsonUtil`: `reader.<T>readValues(json)`;

См. <a href="https://docs.oracle.com/javase/tutorial/java/generics/methods.html">Generic Methods</a>. Когда компилятор не может вывести тип, можно его уточнить при вызове generic метода. Не важно static или нет.

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW07

- Добавить тесты контроллеров:
  - `RootControllerTest.testMeals` для `meals.jsp`
  - `ResourceControllerTest` для `style.css` (status и ContentType)
- Реализовать `MealRestController` и протестировать его через `MealRestControllerTest`
  - cледите чтобы url в тестах совпадал с параметрами в методе контроллера. Можно добавить логирование `<logger name="org.springframework.web" level="debug"/>` для проверки маршрутизации.
  - в параметрах `getBetween` принимать `LocalDateTime` (конвертировать через Spring, <a href="http://blog.codeleak.pl/2014/06/spring-4-datetimeformat-with-java-8.html">@DATETIMEFORMAT WITH JAVA 8 DATE-TIME API</a>), а передавать в тестах в формате `ISO_LOCAL_DATE_TIME` (например `'2011-12-03T10:15:30'`).

#### Optional
- Заменить `@DateTimeFormat` на свой LocalDateTime конвертор или форматтер.
- Протестировать `MealRestController` через любой инструмент (SoapUi, curl, IDEA Test RESTful Web Service, Postman)
  -  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config-conversion">Кастомный Spring конвертор</a>
  -  <a href="http://stackoverflow.com/questions/13048368/difference-between-spring-mvc-formatters-and-converters">Difference between Spring MVC formatters and converters</a>

---------------------
## ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Подсказки по HW07
- для тестирования в MealRestController списка MealWithExceeded сделайте ModelMatcher&lt;MealWithExceed&gt;
- Ошибка в тесте _Invalid read array from JSON_ обычно расшифровывается немного ниже: читайте внимательно.
