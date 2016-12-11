# Онлайн проект <a href="https://github.com/JavaWebinar/topjava08">Topjava</a>

### <a href="https://drive.google.com/drive/folders/0B9Ye2auQ_NsFfmctT3oyNW1qaVhDb2p0bGpyTFVlaUJ2VVpOdVgtWF9KTUFBMWFaR2xVYVE">Материалы занятия (скачать все патчи можно через Download папки patch)</a>

### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Правки в проекте
#### Apply 0-fix.patch

> - Сделал поля User с доступом private  
> - Заменил в `JdbcMealRepositoryImpl` userMeal на meal
> - Починил интеграцию с <a jref="https://travis-ci.org/">Travis CI</a>: на старте создается ДБ topjava и пользователь user без пароля (второй вариант- по умолчанию переключиться на hsqldb)

- <a href="https://docs.travis-ci.com/user/database-setup/#PostgreSQL">Start PostgreSQL in your .travis.yml</a>

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW4

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVFVVUGctMUxxSkE">Разбор вопросов</a>
- <a href="http://stackoverflow.com/questions/8994864/how-would-i-specify-a-hibernate-pattern-annotation-using-a-regular-expression">Validate by RegExp</a>
- <a href="http://www.objectdb.com/java/jpa/persistence/managed#Entity_Object_Life_Cycle">Working with JPA Entity Objects</a>
- <a href="https://en.wikibooks.org/wiki/Java_Persistence/Relationships">Java Persistence/Relationships</a>
- <a href="http://articles.javatalks.ru/articles/17">Использование ThreadLocal переменных</a>
- <a href="http://stackoverflow.com/questions/1069992/jpa-entitymanager-why-use-persist-over-merge">Merge vs Persist</a>
- <a href="http://www.youtube.com/watch?v=1KphwODu1gg">Видео: работа в ZK с OpenJPA (в чем Hibernate хуже)</a>
- <a href="https://developer.jboss.org/wiki/OpenSessionInView">Паттерн- открытие транзакции в фильтре</a> и <a href="http://stackoverflow.com/questions/1103363/why-is-hibernate-open-session-in-view-considered-a-bad-practice">почему это bad-practice</a>
- <a href="https://en.wikibooks.org/wiki/Java_Persistence/Identity_and_Sequencing#Sequence_Strategies">Sequence Strategies</a>
- <a href="http://stackoverflow.com/questions/9470442/why-is-the-hibernate-default-generator-for-postgresql-sequencegenerator-not?lq=1">SequenceGenerator/IdentityGenerator in PostgreSql</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNFMyMGJCZWE4elk">HW4: JPA. @Rule</a>
#### Apply 1-HW4.patch
#### Apply 2-HW4-optional.patch

Изменения в проекте:

-  <a href="http://stackoverflow.com/a/33001846/548473">Hibernate 5.2.x already include Java 8 date and time types (JSR-310)</a>
-  <a href="http://stackoverflow.com/questions/14892125/what-is-the-best-practice-to-determine-the-execution-time-of-the-bussiness-relev#27868954">Stopwatch</a>

## Занятие 5:
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZENCVEhDMkZiV00">Транзакции</a>
-  <a href="https://ru.wikipedia.org/wiki/Транзакция_(информатика)">wiki Транзакция</a>
-  <a href="https://jira.spring.io/browse/DATAJPA-601">readOnly и Propagation.SUPPORTS</a>
- Ресурсы:
  - <a href="http://blog.jhades.org/how-does-spring-transactional-really-work/">How does Spring @Transactional Really Work</a>
  - <a href="https://www.ibm.com/developerworks/ru/library/j-ts1/">Стратегии работы с транзакциями: Распространенные ошибки</a>
  - <a href="http://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation">Spring @Transactional - isolation, propagation</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNW0yVWhXcGNPU2M">Профили Maven и Spring</a>
#### Apply 3-profiles-connection-pool.patch
 > Для переключения на HSQLDB необходимо:
 >  - поменять в окне Maven Projects профиль (Profiles) на `hsqldb` и сделать `Reimport All Maven Projects` (1я кнопка)
 >  - поменять `Profiles.ACTIVE_DB = HSQLDB`
 >  - почистить проект `mvn clean` (фаза `clean` не выполняется автоматически, чтобы каждый раз не перекомпилировать весь проект)

 > Вопрос: почему после apply не запустится Tomcat?
 
- <a href="https://dzone.com/articles/using-spring-profiles-xml">Using Spring Profiles in XML Config</a>
- <a href="https://www.mkyong.com/spring/spring-profiles-example/">Spring Profiles example</a>

> Галочка в XML профиле влияет только на отображение в IDEA и никак на выполнение кода.

- Дополнительно: <a href="http://stackoverflow.com/questions/20551681/spring-integration-tests-with-profile">использование `ActiveProfilesResolver` для профиля тестов</a>
 
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTWJOdHduOWtNcTA">Пул коннектов</a>
-  Выбор реализации пула коннектов: <a href="http://www.jolbox.com/">BoneCP</a>, <a href="https://commons.apache.org/proper/commons-dbcp/">Commons Database Connection Pooling</a>, <a href="https://github.com/brettwooldridge/HikariCP">HikariCP</a>
-  <a href="https://habrahabr.ru/post/269023/">Самый быстрый пул соединений на java (читаем комменты)</a>
-  <a href="http://blog.ippon.fr/2013/03/13/improving-the-performance-of-the-spring-petclinic-sample-application-part-3-of-5">Tomcat pool</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYVdyMFYxRUR6bWM">Spring Data JPA</a>
#### Apply 4-spring-data-jpa.patch
>  Переименовал классы _Proxy*_ на более адекватные _Crud*_

-  <a class="anchor" id="datajpa"></a><a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>
-  Замена AbstractDAO: <a href="http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories">JPA Repositories</a>
-  Разрешение зависимостей: <a href="http://howtodoinjava.com/2014/02/18/maven-bom-bill-of-materials-dependency/">Maven BOM [Bill Of Materials] Dependency</a>
-  <a href="http://habrahabr.ru/post/232381/">Делегирование. (Spring Data JPA)</a>
-  <a href="https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa">Getting started with Spring Data JPA</a>
-  <a href="http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation">Query methods</a>
-  <a href="http://jeeconf.com/archive/jeeconf-2013/materials/spring-data/">Spring Data – новый взгляд на persistence (JeeConf)</a>
-  <a href="https://www.youtube.com/watch?v=nwM7A4TwU3M">Евгений Борисов — Spring Data? Да, та!</a>
-  Ресурсы:
   -  <a href="https://github.com/spring-projects?query=spring-data">Github repositories</a></li>
   -  <a href="http://www.petrikainulainen.net/spring-data-jpa-tutorial">Spring Data JPA Tutorial</a></li>
   -  <a href="https://blog.42.nl/articles/spring-data-jpa-with-querydsl-repositories-made-easy/">Spring Data JPA with QueryDSL</a></li>

### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Правки в Hibernate Entity
- Сравните запросы в базу в `UserServiceTest.testGetAll()` до и после патча (можете добавить еще ролей).

#### Apply 5-fix-hibernate-issue.patch

- **НЕ ИСПОЛЬЗУЙТЕ  `FetchType.EAGER`**: <a href="http://stackoverflow.com/questions/97197/what-is-the-n1-selects-issue">N+1 selects issue</a>
- Поправил equals/hashCode в соответствии с их реализацией в <a href="https://github.com/spring-projects/spring-data-jpa/blob/master/src/main/java/org/springframework/data/jpa/domain/AbstractPersistable.java">spring-data-jpa `AbstractPersistable`</a>. 
  - <a href="http://stackoverflow.com/questions/5031614/the-jpa-hashcode-equals-dilemma">The JPA hashCode() / equals() dilemma</a>
  - <a href="https://blog.oio.de/2010/09/24/instanceof-fails-with-hibernate-lazy-loading-and-entity-class-hierarchy/">Instanceof fails with Hibernate lazy-loading and entity class hierarchy</a>
  - <a href="http://blog.xebia.com/advanced-hibernate-proxy-pitfalls/">Advanced Hibernate: Proxy Pitfalls</a>
- Сделал доступ к полю `BaseEntity.id` через `AccessType.PROPERTY`: <a href="https://hibernate.atlassian.net/browse/HHH-3718">hibernate bug with proxy initialization when using `AccessType.FIELD`</a>   
  - <a href="http://stackoverflow.com/questions/594597/hibernate-annotations-which-is-better-field-or-property-access">Which is better, field or property access?</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFajd2Y2RLQVVJWUU">Spring кэш</a>
#### Apply 6-spring-cache.patch
-  <a href="http://habrahabr.ru/post/113945/">Кеширование в Spring Framework</a>
-  <a href="http://www.ehcache.org/">EHCACHE</a>
-  В случае проблем с размещением кэш в `java.io.tmpdir` (нет доступа) смотри http://stackoverflow.com/questions/1924136/environment-variable-to-control-java-io-tmpdir
-  Ресурсы:
   -  <a href="http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/cache.html">Spring cache Abstraction</a>
   -  <a href="http://habrahabr.ru/post/25140/">Распределённая система кеша ehcache</a>
   -  Починка JUnit: <a href="http://stackoverflow.com/questions/10013288/another-unnamed-cachemanager-already-exists-in-the-same-vm-ehcache-2-5">один кэш на JVM</a>

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы
> В <a href="https://github.com/spring-projects/spring-petclinic/tree/master/src/main/java/org/springframework/samples/petclinic/repository/springdatajpa">spring-petclinic</a> `DataJpa` реализована без без дополнительных классов. В таком виде как у них, spring data смотрится, конечно, намного лаконичней других реализаций, но у нас получилось  вдвое больше кода, чем с тем же jpa или jdbc. Плюс только пожалуй в том, что query находятся прямо в репозитории, а  не где-то там в другом пакете. Так что получается, spring data лучше подходит для простейших crud без всяких "фишек"? или в чем его достоинство для больших и сложных проектов?

Достоинство DATA-JPA по сравнению например с JPA: есть типизация, готовые реализации типовых методов CRUD а также paging, data-common. Мы можем переключить реализацию JPA, например, на mongoDb (`PagingAndSortingRepository`, от которого наследуется `JpaRepository` находится в `spring-data-common`).
Соответственно его методы будут поддерживаться всеми реализациями `spring-data-common`, JPA одна из них и пр. Подробнее о них есть в видео <a href="http://jeeconf.com/archive/jeeconf-2013/materials/spring-data/">Spring Data – новый взгляд на persistence</a>.
Дополнительное проксирование в DATA-JPA - моя "фишка" для устранения минусов этого фреймворка: невозможность дебага, привязка к интерфейсу JpaRepository, перенос логики Repository в слой сервисов.
Для большого приложения выигрыш этого стоит. Для небольших можно не делать дополнительных классов и перенести логику (если есть) в слой сервиса.

> Почему мы для InMemory не сделали отдельного профиля? Почему их не удалить вообще?

Реализация InMemory является примером как в test делать моки с подменой контекста. Для них сделали отдельный `mock.xml` и запускаемый проект ничего не должен о них знать. У нас учебный проект, в котором 4 реализации репозиториев, в реальном такого не будет.

> А как делать транзакционность для реализации jdbc?

Будем делать на следующем уроке

--------------------

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZFdWWFdwams0eGM">Домашнее задание HW05</a>

1. Имплементировать `DataJpaMealRepositoryImpl`
2. Разделить реализации Repository по профилям Spring: `jdbc`, `jpa`, `datajpa` (общее в профилях можно объединять, например `<beans profile="datajpa,jpa">`). Новые профили ортоганальны (независимы) от `postgres`, `hsqldb`.
3. Сделать тесты всех реализаций (`jdbc, jpa, datajpa`) через наследование (без дублирования), **сделать общий базовый класс для `MealServiceTest` и `UserServiceTest`**.
4. Запустить все тесты: `mvn test` или в IDEA Maven Lifecycle - test (кнопку skipTest отжать)

#### Optional

1. Починить `JdbcMealRepositoryImpl` (HSQLDB не умеет работать с Java8 Time API). Например разделить реализацию для HSQLDB и Postgres через `@Profile`.
2. Починить `MealServlet` и использовать в `SpringMain` реализацию DB: добавить профили. Попробуйте поднять Spring контекст без использования `spring.profiles.activ`.
3. Сделать и протестировать в сервисах методы
  - 3.1  достать по id пользователя вместе с его едой
  - 3.2  достать по id еду вместе с пользователем
  - Сделать реализацию только для `DataJpa`, обращения к DB сделать в одной транзакции (можно сделать разные варианты). 

<a href="https://en.wikibooks.org/wiki/Java_Persistence/OneToMany">Java Persistence/OneToMany</a>

---------------------
### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Подсказки по HW05
- Для того, чтобы не запускались родительские классы тестов нужно сделать их `abstract`
- Для интеграции с IDEA не забудте выставить в `spring-db.xml` справа вверху в `Change Profiles...` профили, например `datajpa, postgres`
- Общие части для всех в `spring-db.xml` можно оставить как есть без профилей, но до первого `<beans profile=` (вверху файла).
- В реализациях `JdbcMealRepository` **код не должен дублироваться**. Если вы возвращаете тип `Object`, посмотрите в сторону <a href="http://www.quizful.net/post/java-generics-tutorial">дженериков</a>.
- В `MealServlet/SpringMain` в момент `setActiveProfiles` контекст спринга еще не должен быть инициализирован, иначе выставление профиля уже ничего не будет делать.
- Если у метода нет реализации, то стандартно бросается `UnsupportedOperationException`.
- Для уменьшения количества кода при реализации _Optional_ попробуйте сделать `default` метод в интерфейсе
