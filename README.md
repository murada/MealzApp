
# MealzApp

In this project i used the open API from [The Meal DB](https://www.themealdb.com/) to build a cleane Android compose app, following uncle bob clean architucture.




## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.


## [The Meal DB](https://www.themealdb.com/) API   Reference


```
  BASE_URL www.themealdb.com/api/json/v1/1/
```

#### till now I implemented those APIs:
#### Get all meal's categories

```
  GET /categories.php
```

#### Get meals by category

```
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

- [x]  Adding list of meals categories.
- [X]  List the meals by category.
- [ ]  Implement meal details api :tada:
- [ ]  Create meal details screen :tada:
- [ ]  Search meal by name :tada:
- [ ]  List the meals by **Area**.
- [ ]  Filter Meals by **Main Ingredient**.
- [ ]  Favorite meal.
- [ ]  List of favorite meals.

## License

[MIT](https://choosealicense.com/licenses/mit/)

