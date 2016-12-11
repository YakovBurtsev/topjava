# Онлайн проекта <a href="https://github.com/JavaWebinar/topjava08">Topjava</a>

### <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFfkF5c1hiWmstT0prODdtZkVuNFlMZmdtN3J0OUcyY0lkT2NlVzlUMXRUUlk">Материалы занятия (скачать все патчи можно через Download папки patch)</a>


### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Правки в проекте
#### Apply 0-fix.patch
> - `@SuppressWarnings("JpaQlInspection")`. <a href="https://jazzy.id.au/2008/10/30/list_of_suppresswarnings_arguments.html">Other warnings</a>
> - Заменил `JpaMealRepositoryImpl.get`, запрос в базу и реализация стали проще
> - Поправил `InMemoryUserRepositoryImpl.USER_COMPARATOR`: при одинаковых именах сравниваем email. 

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW5

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUVZobXRzNWFzUW8">HW5: Spring Profiles. Spring Data JPA</a>
#### Apply 1-HW5-data-jpa.patch
#### Apply 2-HW5-profiles.patch

> Для IDEA не забудте выставить Spring Profiles в `spring-db.xml`: нарпимер `datajpa, postgres`

#### Apply 3-HW5-tests.patch

> - `DbTest` переименован в `AbstractServiceTest` и сюда перенес `@ActiveProfiles(Profiles.POSTGRES)`
> - Заменил `StringBuffer` на `StringBuilder` в выводе результатов тестов. После вывода буфер сбрасывается в 0, чтобы не накапливать изменения. 

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFejhtNkI0RGpVd1E">HW5: Optional</a>

#### Apply  4-HW5-optional-fix-jdbc-profiles

> - HSQLDB driver не понимает `LocalDateTime`, сделал внутренние классы: `Java8JdbcMealRepositoryImpl` и `TimestampJdbcMealRepositoryImpl`

- <a href="http://javarticles.com/2013/12/spring-profiles.html">Spring Profiles</a>. <a href="https://www.javacodegeeks.com/2013/10/spring-4-conditional.html">Spring 4 Conditional</a>. 
- Зайдите в исходники `@Profile` и посмотрите его  реализацию через `@Conditional(ProfileCondition.class)`.
- `Profiles.ACTIVE_DB` и `Profiles.DB_IMPLEMENTATION` задают конкретные профили при запуске приложения или запуске тестов. Бины Spring мы разделяем по разным профилям с помощью `beans profile` в xml конфигурации и `@Profile`. 
 
#### Apply 5-HW5-optional-fetch-join.patch

-  <a href="http://stackoverflow.com/questions/11938253/jpa-joincolumn-vs-mappedby">JPA JoinColumn vs mappedBy</a>
-  <a href="https://en.wikibooks.org/wiki/Java_Persistence/OneToMany#Unidirectional_OneToMany.2C_No_Inverse_ManyToOne.2C_No_Join_Table_.28JPA_2.x_ONLY.29">Unidirectional OneToMany</a>

> Добавлены проверки и тесты на `NotFound` для `MealService.getWithUser` и  `UserService.getWithMeals`

## Занятие 6:
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFeTV0SUFfblk5NE0">Кэш Hibernate</a>
#### Apply 6-hibernate-cache.patch
>  Jdbc тесты поломались. Требуется починить в HW6

-  <a href="http://habrahabr.ru/post/135176/">Уровни кэширования Hibernate</a>
-  <a href="http://habrahabr.ru/post/136375/">Hibernate Cache. Практика</a>
-  <a href="http://www.tutorialspoint.com/hibernate/hibernate_caching.htm">Hibernate - Caching</a>
-  Починка тестов: <a href="http://stackoverflow.com/questions/1603846/hibernate-2nd-level-cache-invalidation-when-another-process-modifies-the-databas">инвалидация кэша Hibernate</a>
-  Ресурсы:
   - **<a href="https://www.youtube.com/watch?list=PLYj3Bx1JM6Y7BKivc3eZwRUhWwBmbIFXg&v=V-ljsrVy6pE">Hibernate performance tuning (Mikalai Alimenkou /Igor Dmitriev)</a>**
   -  Подключение <a href="http://www.ehcache.org/generated/2.9.0/html/ehc-all/#page/Ehcache_Documentation_Set%2Fco-hib_about_using_ehcache_with_hibernate.html%23wwconnect_header">кэша Hibernate 2-го уровня</a>
   -  <a href="http://stackoverflow.com/questions/3663979/how-to-use-jpa2s-cacheable-instead-of-hibernates-cache">JPA2 @Cacheable vs Hibernate @Cache</a>
   -  <a href="http://habrahabr.ru/post/25140/">Распределённая система кеша ehcache</a>
   -  <a href="http://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html_single/#performance-cache-mapping">Cache mappings</a>
   -  <a href="http://vladmihalcea.com/2015/06/08/how-does-hibernate-query-cache-work/">How does Hibernate Query Cache work</a>
   -  <a href="http://blog.jhades.org/setup-and-gotchas-of-the-hibernate-second-level-and-query-caches/">Pitfalls of the Hibernate Second-Level / Query Caches</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVE1jWkRucm1UTjA">Spring Web</a>
#### Apply 7-spring-web.patch

> - Для сборки проекта в окне Maven отключите тесты (`Toggele 'Skip Tests' Mode`)
> - В `pom.xml` добавляеются профили запуска по умолчанию: `<param-value>postgres,datajpa</param-value>`. Если запускаетесь под HSQLDB - надо поменять.

-  Добавляем в проект веб зависимости
-  Поднятие контекста Spring в веб приложении. <a href="http://www.mkyong.com/servlet/what-is-listener-servletcontextlistener-example/">ServletContextListener</a>. Задание дефолтного профиля.
-  Получение контекста Spring в веб-контейнере
-  <a href="https://docs.oracle.com/javaee/6/tutorial/doc/bnafi.html">Servlet Lifecycle</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5.   <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFN3k0ZVk1MnF5TjQ">JPS, JSTL, internationalization</a>
#### Apply 8-jsp-jstl-i18n.patch
-  <a href="http://docs.oracle.com/javaee/1.3/tutorial/doc/JSPIntro8.html">Including Content in a JSP Page</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6.   <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFLTB3R3pKNFNEQmM">Динамическое изменение профиля при запуске.</a>
>  -Dspring.profiles.active="datajpa,postgres"

- <a href="http://stackoverflow.com/questions/10041410/default-profile-in-spring-3-1#answer-10041835">Set profiles in Spring 3.1</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7.   <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFdkFRRFdYa0NoWkU">Конфигурирование Tomcat через maven plugin. Jndi-lookup.</a>
> - `javax.el-api` scope изменил на `provided` (`el-api.jar` является частью Tomcat)
> - Для запуска в Tomcat 8 поменял `tomcat7-maven-plugin` на `cargo-maven2-plugin`
> - `cargo` плагин сконфигурирован под postgres. Для HSQLDB нужно скорректировать `dependencies` и `driverClassName` в `context.xml`.

Запуск из коммандной строки (`clean` нужен для удаления из сборки зависимости `javax.el-api`):

     mvn clean package -DskipTests=true org.codehaus.cargo:cargo-maven2-plugin:1.5.0:run

#### Apply 9-tomcat-pool-jndi.patch
- <a href="https://codehaus-cargo.github.io/cargo/Maven2+plugin.html">Cargo Maven2 plugin</a>
- <a href="http://stackoverflow.com/questions/4305935/is-it-possible-to-supply-tomcat6s-context-xml-file-via-the-maven-cargo-plugin#4417945">Катомизация context.xml в cargo-maven2-plugin</a>
- <a href="https://tomcat.apache.org/tomcat-8.0-doc/jndi-resources-howto.html"/>Tomcat JNDI Resources</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 8. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQThUX2VyQXNiTHM">Spring Web MVC</a>
#### Apply 10-spring-webmvc.patch
> Починил <a href="http://stackoverflow.com/questions/10327390/how-should-i-get-root-folder-path-in-jsp-page"> путь к корню</a>

-  <a class="anchor" id="mvc"></a><a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Spring Web MVC</a>
-  <a href="http://design-pattern.ru/patterns/front-controller.html">Паттерн Front Controller</a>
-  Добавляем DispatcherServlet и MVC application context.
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/integration-testing.html#testcontext-ctx-management-ctx-hierarchies">Иерархия контекстов в Spring Web MVC</a>
-  <a href="http://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm">Сценарий обработки запроса</a>. <a href="http://www.studytrails.com/frameworks/spring/spring-mvc.jsp">HandlerMappings</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-viewresolver-resolver">View resolving</a>: прячем jsp под WEB-INF.
-  HandlerMapping: <a href="http://www.mkyong.com/spring-mvc/spring-mvc-simpleurlhandlermapping-example/">SimpleUrlHandlerMapping</a>, <a href="http://www.mkyong.com/spring-mvc/spring-mvc-beannameurlhandlermapping-example/">BeanNameUrlHandlerMapping</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config-static-resources">Маппинг ресурсов.</a>
-  Ресурсы:
   -  <a href="http://www.jpalace.org/document/34/spring-mvc-tutorial">Spring MVC Tutorial</a>
   -  <a href="http://www.mkyong.com/spring-mvc/spring-mvc-hello-world-example/">Spring MVC hello world</a>
   -  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Web MVC framework</a>
   -  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-webappctx-special-beans-tbl">Special bean types in the WebApplicationContext</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 9. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUEctTkRSMWNvRjg">Spring Internationalization</a>
#### Apply 11-spring-i18n.patch

> - Убедитесь что <a href="https://github.com/JavaOPs/topjava/wiki/IDEA#%D0%9F%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%B8%D1%82%D1%8C-%D0%BA%D0%BE%D0%B4%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D1%83-utf-8">в настройках IDEA кодировка везде UTF-8</a>
> - Проверьте, что файлы локализации у вас в UTF-8 (в IDEA справа внизу в статусе есть кодировка и можно перекодировать).

-  <a href="http://simplespringtutorial.com/i18n.html">Spring Internationalization or i18n</a>
-  <a href="http://learningviacode.blogspot.ru/2012/07/reloadable-messagesources.html">Reloadable MessageSources</a>
-  <a href="http://nginx.com/resources/admin-guide/serving-static-content/">nginx: Serving Static Content</a>

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы
>  Кэш hibernate надстраивается над ehcache или он живет самостоятельно?

- <a href="http://mrbool.com/understanding-hibernate-caching/28721">Understanding Hibernate Caching</a>:
Hibernate supports following open-source cache implementations out-of-the-box: EHCache (Easy Hibernate Cache), OSCache (Open Symphony Cache), Swarm Cache, and JBoss Tree Cache.

> Где конфигурится интернализация для jstl (т.е. файл, где задаются app, app_ru.properties)? Достаточно указать в страницах бандл и путь в ресурсы?

`<fmt:setBundle basename="messages.app"/>` означает что ресурсы будут искаться в `classpath:messages\app(_xx)/properties`:
<a href="http://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/fmt/setBundle.html">Tag setBundle</a>: fully-qualified resource name, which has the same form as a fully-qualified class name.
После сборки проекта maven их можно найти в target\classes или target\topjava\WEB-INF\classes.


> Отлично, что она все пишет на том языке, который пришел в хидере запроса. А если я хочу выбрать?

Для этого используется <a href="http://www.codejava.net/java-ee/jstl/jstl-format-tag-setlocale">JSTL Format Tag fmt:setLocale</a>. Мы будем реализовывать переключение локалей только в Spring i18n.

> Мы создаем бин, где получаем dataSource по имени `<jee:jndi-lookup id="dataSource" jndi-name="java:comp/env/jdbc/topjava"/>`.
Но там не указан класс, как в других dataSource? Получается по имени jdbc/topjava нам уже отдает готовый обьект dataSource и мы как бы помещаем его в бин?

Здесь используется namespace `jee:jndi-lookup`, который прячет под собой классы реализации. JNDI объект DataSource конфигурируется в `src/main/resources/tomcat/context.xml`

> В плагине прописан профиль `<spring.profiles.active>tomcat,datajpa</spring.profiles.active>`, а в web.xml `<param-value>postgres,datajpa</param-value>`.
Какой же реально отрабатывает?

См видео урока "Динамическое изменение профиля при запуске". В плагине мы задаем параметры JVM запуска Tomcat

> Почему мы не используем элемент `<context:annotation-config/>` в `spring-db.xml`?

В проекте у нас сейчас 2 Spring контекста: `spring-mvc.xml (см. web.xml, DispatcherServlet)` и родительский `spring-app.xml + spring-db.xml (web.xml, contextConfigLocation)`.
Грубо: 2 мапы, причем для mvc доступно все что есть в родителе. Те `spring-db.xml` не является отдельным самостоятельным контекстом и достаточно того, что `<context:annotation-config/>` у нас есть в `spring-app.xml`.

> В _ehcache.xml_ чем _<cache name="users"_ отличается от _<cache name="ru.javawebinar.topjava.model.User"_?

_user_ - это имя региона ecache, которое мы выбрали для кэширования c помощью Spring Cache `Collection<User> getAll()` в `UserServiceImpl`.
_ru.javawebinar.topjava.model.User_ - имя региона, которое использует Hibernate для кэширования содержимого таблицы _USERS_.
Мы можем оставить настройки по умолчанию, либо задать свои.

> A `@NamedQuery` или `@Query` подвержены кешу запросов? Т.е. если мы поставим _USE_QUERY_CACHE_value_="true" будет Hibernate их кешировать?

Чтобы запрос кэшировался, кроме true в конфигурации нужно еще явно выставить запросу _setCacheable_ (http://vladmihalcea.com/2015/06/08/how-does-hibernate-query-cache-work/). По поводу кэширования `@NamedQuery` нашел `@QueryHint`: https://docs.jboss.org/jbossas/docs/Clustering_Guide/5/html/ch04s02s03.html

> Почему messages мы кладем в config и используем system environment? разве так делают в реальном проекте? не будешь же вписывать на сервере эти переменные каждый раз, если проект куда-то будет переезжать. Можно по другому, кроме systemEnvironment['TOPJAVA_ROOT'] задать путь от корня проекта?

1. messages нам нужны в runtime (при работе приложения). Проект к собранному и задеплоенному в Tomcat war отношения никакого уже не имеет и на этом сервере он обычно не находится. Если ресурсы нужны только при сборке и тестировании, то путь к корню для одномодульного maven проекта можно задать как `${project.basedir}`, но для многомодульного проекта (а все реальные проекты многомодульные) это путь к корню своего модуля.
2. В "реальном приложении" делается совершенно по разному:
   - нести с собой в класспасе, но ресурсы нельзя будет динамически (без передеплоя) обновлять
   - класть в war (не в класспас) и обновлять в развернутом TOMCAT_HOME/webapps/[appname]/...
   - класть в зафиксированное определенное место (нарпимер в home: `~` или в путь от корня `/app/config`). Можно задавать фиксированный пусть в пропертях профиля maven и фильтровать ресурсы (maven resources), чтобы они попали в проперти проекта.
   - делать через переменную окружения, как у нас
   - задавать в параметрах запуска JVM как системную переменную через -D..
   - располагать в преференсах (для unix это home, для windows- registry): <a href="http://java-course.ru/articles/preferences-api/">использование Preferences API</a>
   - держать настройки в DB

   Часто в одном приложении используют несколько способов для разных видов конфигураций.

> Не происходит ли дублирования при кэшировании пользователей чрез Hibernate и `@Cacheable` ?

`@Cacheable` кэширует результат запроса `getAll()`, те список юзеров. Hibernate кэширует юзеров по отдельности, те, грубо мапа, id->User. Те можно назвать это дублированием. Нужно ли будет такое в реальном приложении - все смотрится из логики запросов и их частоты, вполне вероятно что нет. Как то мы писали приложение для Дойчебанка (аналог skype на GWT, те на экране небольшое окошко)- там было 5!! уровней кэширования, первый вообще в базе.

> У меня стоит томкат 7 версии, в помнике у нас 8 прописан, но всё работает. Почему?

В pom.xml мы подключаем servlet-api версии 3.1 со `scope=provided`, что означает что он используется только для компиляции и не идет в war. Тк мы не используем никаких фич 3.1, то наш код совместим с Tomcat 7.x. При запуске через `cargo-maven2-plugin` Tomcat 8 загружается из maven репозитория.

> Откуда @Transactional вытягивает класс для работы с транзакцией, в составе какого бина он идет?

1. Если в контексте Spring есть `<tx:annotation-driven/>`, то подключается `BeanPostProcessors`, который проксирует классы (и методы), помеченные `@Transactional`.
2. По умолчанию для TransactionManager используется бин с `id=transactionManager`

---------------------------

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW06
- 1.1 Починить InMemory и Jdbc тесты
- 1.2 Починить работу meals: перенести функциональность `MealServlet` в контроллеры (сервлеты удалить)
  - 1.2.1 разнести запросы на update/delete/.. по разным методам (попробуйте вообще без `action=`). Можно по аналогии с `RootController#setUser` принимать `HttpServletRequest request` (аннотации на параметры и адаптеры для `LocalDate\Time` мы введем позже).
  - 1.2.3 Добавить локализацию и `jsp:include` в meal/meals.jsp

#### Optional
- 2.1 Добавить еще одну роль к ADMIN (будет 2 роли: `ROLE_USER, ROLE_ADMIN`), добавить проверку ролей в тесты на User, починить тесты Jpa и DataJpa
   - <a href="http://www.thoughts-on-java.org/5-ways-to-initialize-lazy-relations-and-when-to-use-them/">5 ways to initialize lazy relationsships</a>
   - <a href="https://docs.oracle.com/javaee/7/tutorial/persistence-entitygraphs002.htm">Using Named Entity Graphs</a>
   - <a href="https://jira.spring.io/browse/DATAJPA-792">@EntityGraph doesn't work if mix graph levels</a>
   - <a href="https://dou.ua/lenta/articles/jpa-fetch-types/">Стратегии загрузки коллекций в JPA</a>
   - <a href="https://dou.ua/lenta/articles/hibernate-fetch-types/">Стратегии загрузки коллекций в Hibernate</a>
   
- 2.2 Добавить транзакционность (`DataSourceTransactionManager`) в Jdbc реализации  
- 2.3 Починить тесты в `JdbcUserRepositoryImpl` (добавить роли). 
  - 2.3.1 В реализации `getAll` НЕ делать запрос ролей для каждого юзера
  - 2.3.2 При save посмотрите на <a href="https://www.mkyong.com/spring/spring-jdbctemplate-batchupdate-example/">batchUpdate()</a>

---------------------
## ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Подсказки по HW06
- Неверная кодировка UTF-8 с Spring обычно решается фильтром `CharacterEncodingFilter`:
```
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```
- если не поднимается контекст Spring, смотрим верх самого нижнего эксепшена - там написано какого бина у вас нет в контексте.
Его нужно включить в контекст, например, если не резолвится контроллер, посмотреть, если ли у вас в контексте `spring-mvc.xml`
- Если неправильно формируется url относительно контекста приложения, посмотрите http://stackoverflow.com/questions/4764405/how-to-use-relative-paths-without-including-the-context-root-name
- При проблемах с запуском томкат проверьте запущенные `java` процессы, нет ли в `TOMCAT_HOME\webapps` приложения каталога `topjava`, логи tomcat - нет ли проблем с доступом к каталогам или контекстом Spring.
- Если создаете List с одним значением или Map с одним ключом-значением, пользуйтесь `Collections.singleton..`
