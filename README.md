# Java UI Test

![Static Badge](https://img.shields.io/badge/Java-white)
![Static Badge](https://img.shields.io/badge/JUnit-white)
![Static Badge](https://img.shields.io/badge/Selenium-white)
![Static Badge](https://img.shields.io/badge/Webdriver-white)
![Static Badge](https://img.shields.io/badge/Maven-white)

## Установка

Для запуска проекта необходимо установить драйвер для браузера. В проекте используется [ChromeDriver](https://developer.chrome.com/docs/chromedriver).

## Запуск

 В конфигурационном файле conf.properties представлены loginpage (страница, которую вы хотите тестировать) и chromedriver (путь до драйвера вашего браузера). Их необходимо будет понять на собственные значения.

 ```
loginpage=
chromedriver=
```
Установка зависимостей

```
mvn clean install
```

Запуск тестов

```
mvn test
```

