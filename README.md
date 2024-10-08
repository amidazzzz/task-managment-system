# Task Management System

## Описание

Система управления задачами (Task Management System) — это простое приложение, реализующее REST API для управления задачами. Пользователи могут создавать, редактировать, удалять и просматривать задачи, а также оставлять комментарии к ним. Каждая задача содержит заголовок, описание, статус и приоритет, а также информацию об авторе и исполнителе.

## Функциональные возможности

- Создание, редактирование, удаление и просмотр задач
- Аутентификация и авторизация пользователей по email и паролю
- Использование JWT токенов для доступа к API
- Управление задачами: изменение статуса и назначение исполнителей
- Комментарии к задачам
- Обработка ошибок и валидация входящих данных

## Технологии

- Java 17
- Spring Boot
- Spring Security
- PostgreSQL
- Docker для развертывания среды

## Установка

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/amidazzzz/task-managment-system.git
   
2. Убедитесь, что у вас установлен Docker и Docker Compose.

3. Настройте файл `.env` с параметрами базы данных.

4. Запустите проект с помощью Docker Compose:
```bash
docker-compose up --build
```
5. Сервис будет доступен по адресу http://localhost:8080.

## Использование
API поддерживает следующие конечные точки:

POST /api/auth/login: Аутентификация пользователя.

POST /api/auth/register: Регистрация пользователя.

POST /api/tasks/create: Создать новую задачу.

PUT /api/tasks/{id}: Обновить существующую задачу.

GET /api/tasks/author/{userId}: Получить все задачи автора с id=userId.

POST /api/tasks/{taskId}: Удалить задачу.

GET /api/tasks/{taskId}/comments: Получить комментарии к задаче.

POST /api/tasks/{taskId}/comments: Добавить комментарии к задаче.

## Документация
API будет документировано с помощью Open API и Swagger. Swagger UI будет доступен по адресу http://localhost:8080/swagger-ui.html после запуска сервиса.

## Лицензия
Этот проект лицензируется на условиях MIT License.
