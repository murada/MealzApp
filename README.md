
# MealzApp

In this project i used the open API from [The Meal DB](https://www.themealdb.com/) to build a cleane Android compose app, following uncle bob clean architucture.




## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.


## [The Meal DB](https://www.themealdb.com/) API   Reference


```http
  BASE_URL www.themealdb.com/api/json/v1/1/

```

#### till now I implemented those APIs:
#### Get all meal's categories

```http
  GET /categories.php
```

#### Get meals by category

```http
  GET /filter.php?c={category_name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `c`      | `string` | **Required**. category of item to fetch |




## Tech Stack

- **Language:** **Kotlin**

- **Jetpack-Compose:**
- **Compose-Navigation**.
- **Compose-ViewModel**.

- **Network:**

    - **[KTOR](https://ktor.io/docs/welcome.html):** in **Koin Branch**.

    - **[Retrofit](https://github.com/square/retrofit):** in  **Master Branch**.


- **Dependency Injection:**

    - **Koin:** in **Koin Branch**
    - **Hilt-Dagger:** in **Master Branch**


- **[Coil](https://coil-kt.github.io/coil/compose/):** for images
- **Material3**.







## Features
- Implemented:
    - List Meal's Categories
    - List of Meals based on Category
- Future:
    - search
    - favrite meal
    - list of favorite meals



## License

[MIT](https://choosealicense.com/licenses/mit/)

