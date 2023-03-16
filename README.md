
<p align="center">
  <img width="200" height="200" alt="AdotaPet" src="https://campanha.condor.com.br/wp-content/uploads/2022/07/pets.png">
</p>

# **AdotaPet**

AdotaPet é uma plataforma voltada para a adoção de animais, que serão publicados por ONGs inseridas no sistema. Há um feed com fotos e informações acerca do pet e suas características. A solicitação de adoção é realizada através do próprio sistema e caso a mesma seja aprovada, o usuário terá acesso a essa informação acessando a aba de "Minhas Adoções" na plataforma.


## Contribuição

O projeto contribui para que as adoções de pets sejam feitas de maneira mais ágil, não deixando também de ser um processo seguro. Há também a contribuição social do projeto, que visa auxiliar no aumento do número de animais adotados.


## Construção e Instalação




## Licença


## Links Importantes

[Protótipos](https://www.figma.com/proto/REiCfRAQhnueTD10m7YwKJ/Adota-Pet?node-id=2%3A74&starting-point-node-id=2%3A74&scaling=scale-down)

[Notion](https://www.notion.so/webacademy-handson-pro-pet/Time-PRO-Ado-o-de-Pet-585016ebdacc48208ff1506c80d95668)

# Documentação da API

## *Api de Produção*

[https://adota-pet-production.up.railway.app/](https://adota-pet-production.up.railway.app/)

## *Api  de Teste*

[https://adota-pet-test-production.up.railway.app/](https://adota-pet-test-production.up.railway.app/)

# Adota Pet - Documentation v1.1

## Adota Pet - API v1.0

## **Authorization**

Nesta seção se encontram as endpoints para autenticação e cadastro de usuário.

****POST Login****

```
https://localhost:9000/api/auth/signin
```

**Body** (json)

json

`{
    "username":"admin@admin.com",
    "password":"admin"
}`

****POST RefreshToken****

```
https://localhost:9000/api/auth/refreshtoken
```

Add request description…

**Body** (json)

json

`{
    "refreshToken": "3dedb589-6ecb-4a42-af34-cc3d23ba8ba0"
}`

****POST Registration****

```
https://localhost:9000/api/auth/signup
```

**Body (**json)

`{
    "username":"Wallison Ferreira",
    "email":"wall@wall.com",
    "password":"wallison"
}`

## **Users**

****GET Users****

```
https://localhost:9000/config/user/
```

**Request Headers**

**Content-Type** application/json

**Authorization** Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ1MzU3MzcsImV4cCI6MTY3NDUzNjA5N30.hRX-L1-vYk5B-O8_YTATqBQwMX43py-HaY2KmRu4NMPuA_Ylf2Xoqp5JFR0UjoKvomD9EXCILSbe7P3zDxI6Gg

****GET User****

```
https://localhost:9000/config/user/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ4NzA1OTYsImV4cCI6MTY3NDg3MDk1Nn0.Lp_LioVbgfg66seW3jtlGgWK0ovQjfKfogqnpd11z7bTEuf6LrKqhHOw78KD7V1YVJcgDQkT9gPU9r6O8uMWyA

****GETSearchUserByRole[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/config/user/searchRole?term=ROLE_ADMIN
```

Add request description…

**Request Headers**

**Content-Type**

application/json

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ4Njk5MzEsImV4cCI6MTY3NDg3MDI5MX0.g110j56tBeZVruuZ0_2-kYHJ8tSvl_-51Gr8zPOoFE5aGdiDOTX6WoxV0X1qdjCTRE3DhThCcUfZVzxdFiRp9w

**Query Params**

**term**

ROLE_ADMIN

****GETSearchUserByName[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/config/user/searchUser?term=Admin
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTAzNzksImV4cCI6MTY3NDk1MDczOX0.M3GkKX2AZEPZvIvm25fWp9W0FtgHpkU2ksvNV7-QqCk4deBRtcH5oyddKZPa29FgLRIRtcQfKi61sHNaNcF-bA

**Query Params**

**term**

Admin

****POSTUserStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/config/user/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ4NzA1OTYsImV4cCI6MTY3NDg3MDk1Nn0.Lp_LioVbgfg66seW3jtlGgWK0ovQjfKfogqnpd11z7bTEuf6LrKqhHOw78KD7V1YVJcgDQkT9gPU9r6O8uMWyA

**Body**raw (json)

json

`{
    "name": "Daniel Right",
    "email": "daniel@mail.cobit",
    "password":"admin"
}`

****PUTUserUpdate[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/config/user/13
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ4NzEwNDYsImV4cCI6MTY3NDg3MTQwNn0.WRZcz8beXVELNpOuY1LZbY2BAkpZhJ0gpaRVJz_Qhmh2E8Kk198MCiZStG4tTfstMs3uJvRJpzl_aShzWw7ODg

**Body**raw (json)

View More

json

`{
    "name": "Daniel Elias",
    "email": "djean@gmail.com",
    "cpf": null,
    "phone": null,
    "age": 23,
    "verified": false,
    "active": true,
    "profilePicture": null,
    "createdAt": "2023-01-11",
    "updatedAt": "2023-01-11",
    "deletedAt": null,
    "role": "ROLE_USER"
}`

****DELETEUserDelete[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/config/user/37
```

Add request description…

**Request Headers**

**Authorization**

Bearer

## **Pets**

Add folder description…

****GETPets[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTA4NjgsImV4cCI6MTY3NDk1MTIyOH0.rJ5puI24KhCg62trpaAVqU6FqrdFcE4YLuiGgdWmdTXXS1KPab8a5Mo7XNsZ6FSni0QepAAEhiG4FcIP849bSQ

****GETPet[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTA4NjgsImV4cCI6MTY3NDk1MTIyOH0.rJ5puI24KhCg62trpaAVqU6FqrdFcE4YLuiGgdWmdTXXS1KPab8a5Mo7XNsZ6FSni0QepAAEhiG4FcIP849bSQ

****GETPetSearch[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/search?term=a
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTA4NjgsImV4cCI6MTY3NDk1MTIyOH0.rJ5puI24KhCg62trpaAVqU6FqrdFcE4YLuiGgdWmdTXXS1KPab8a5Mo7XNsZ6FSni0QepAAEhiG4FcIP849bSQ

**Query Params**

**term**

a

****GETPetOptions[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/options
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTc2NjIsImV4cCI6MTY3NDk1ODAyMn0.AxVmkGfORnI0koTz52j8ex--MHLRhNKtWhlXueNqqatFiU7wGHf-Inr8Yt8de2GA3FMmXXoeA0LFsuyEnriaWg

**Body**raw (json)

View More

json

`{
    "color": {
        "id": 2
    },
    "size": {
        "id": 2
    },
    "race": {
        "id": 2
    },
    "specie": {
        "id": 1
    }
}`

****POSTPetFilter[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/filter
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTc2NjIsImV4cCI6MTY3NDk1ODAyMn0.AxVmkGfORnI0koTz52j8ex--MHLRhNKtWhlXueNqqatFiU7wGHf-Inr8Yt8de2GA3FMmXXoeA0LFsuyEnriaWg

**Body**raw (json)

View More

json

`{
    "color": {
        "id": 2
    },
    "size": {
        "id": 2
    },
    "race": {
        "id": 2
    },
    "specie": {
        "id": 1
    }
}`

****POSTPetStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTA4NjgsImV4cCI6MTY3NDk1MTIyOH0.rJ5puI24KhCg62trpaAVqU6FqrdFcE4YLuiGgdWmdTXXS1KPab8a5Mo7XNsZ6FSni0QepAAEhiG4FcIP849bSQ

**Body**raw (json)

View More

json

`{
    "name": "Layla",
    "tag": "JVZE-V76D-GEC4-4NVC",
    "description": "Vermifugada.",
    "lost": false,
    "active": true,
    "profilePicture": "https://images.pexels.com/photos/1431557/pexels-photo-1431557.jpeg",
    "user": {"id": 1},
    "color": {"id": 5},
    "size": {"id": 2},
    "race": {"id": 2},
    "specie": {"id": 1}
}`

****PUTPetUpdate[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/28
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTA4NjgsImV4cCI6MTY3NDk1MTIyOH0.rJ5puI24KhCg62trpaAVqU6FqrdFcE4YLuiGgdWmdTXXS1KPab8a5Mo7XNsZ6FSni0QepAAEhiG4FcIP849bSQ

**Body**raw (json)

View More

json

`{
    "name": "Lois",
    "tag": "JVZE-V76D-GEC4-4NVC",
    "description": "Vermifugada.",
    "age": 2,
    "lost": false,
    "active": true,
    "profilePicture": "https://images.pexels.com/photos/1431557/pexels-photo-1431557.jpeg",
    "user": {"id": 2},
    "color": {"id": 5},
    "size": {"id": 1},
    "race": {"id": 1},
    "specie": {"id": 1}
}`

****DELETEPetDelete[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/28
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ5NTA4NjgsImV4cCI6MTY3NDk1MTIyOH0.rJ5puI24KhCg62trpaAVqU6FqrdFcE4YLuiGgdWmdTXXS1KPab8a5Mo7XNsZ6FSni0QepAAEhiG4FcIP849bSQ

## **Specie**

Add folder description…

****GETSpecie[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/specie/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NTE5ODgsImV4cCI6MTY3NDc1MjM0OH0.nCTz85IYiCk04B0DGfAgf6thl91qL4QmAqE-g6UNsBCxvotcoqVue94-fKsONr87eisQfw9aD2rSrh0BCBDWgQ

****GETSpecie[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/specie/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NTI0MjQsImV4cCI6MTY3NDc1Mjc4NH0.teo2Oteplf7IRLzoFbqEB_WtpM2Vky4UiIu73N3svi8Kt9802SxOVr_vqPaqcsSJlK9MQ0YZsUN6UDBO6aWWNg

****POSTSpecieStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/specie/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NTM4MjIsImV4cCI6MTY3NDc1NDE4Mn0.KSuPRfKtqCvVrzqK859baoD3pNMjf8cRpOnmapotmMS8Rg0H7NJLuEKDPIBj6bdThTKJDIwBu-rIHaJJZ-yIXQ

**Body**raw (json)

json

`{
    "specieName": "Ave"
}`

****PUTPetUpdate[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/specie/3
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NTM4MjIsImV4cCI6MTY3NDc1NDE4Mn0.KSuPRfKtqCvVrzqK859baoD3pNMjf8cRpOnmapotmMS8Rg0H7NJLuEKDPIBj6bdThTKJDIwBu-rIHaJJZ-yIXQ

**Body**raw (json)

json

`{
    "specieName": "Pássaros"
}`

****DELETEPetDelete[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/3
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NTM4MjIsImV4cCI6MTY3NDc1NDE4Mn0.KSuPRfKtqCvVrzqK859baoD3pNMjf8cRpOnmapotmMS8Rg0H7NJLuEKDPIBj6bdThTKJDIwBu-rIHaJJZ-yIXQ

## **Race**

Add folder description…

****GETRace[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3Njk0MjIsImV4cCI6MTY3NDc2OTc4Mn0.gs86wWgQXz9ygD2NSfzwvWOvTN3WfNam73SC2I5YT1Tl8nEh3EMz-ObEcy0UlULiJ9u1qld9x19CR5FLca8FPg

****GETRace[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3Njk5MjAsImV4cCI6MTY3NDc3MDI4MH0.eKfAf9ExP3lzmFOcxq0qZbi1O9cBZivZhwnVVWNfMaFVj3AotfVSKPs23P1R_N5E8S0CEp25iBvzTWJdp2Qp7A

****GETRaceSearch[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/search?term=York
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzU2NDAsImV4cCI6MTY3NDc3NjAwMH0.J0OiaIL_rkJGSLDkaUuqczynGTwPbms6T3nhQI9nYg1kgH-mwOMKFN8fvNML9TdQyPRVjt-OzK0jv7H-rQcUfg

**Query Params**

**term**

York

****GETRaceBySpecie[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/specie/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzA2MTgsImV4cCI6MTY3NDc3MDk3OH0.w1x1_MRn10zIvaQ2rGoCvhRjM6kLyfWafs2un4HAuKe8fT3RZ8quR8-PHIbSs9UD1JpCsoZFrSpHSNWgXiu0rQ

****POSTRaceStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzE5MzIsImV4cCI6MTY3NDc3MjI5Mn0.848PFFuYJCx05aSwIitGyS6pzVv2ULQT7-0uaspbLTft6_oAD5_r5uSdMraJFU_IrnJxu_066s1Dk4SAIPS4mQ

**Body**raw (json)

json

`{
    "raceName": "Fila",
    "specie": {"id": 1}
}`

****PUTRaceUpdate[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/22
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzE5MzIsImV4cCI6MTY3NDc3MjI5Mn0.848PFFuYJCx05aSwIitGyS6pzVv2ULQT7-0uaspbLTft6_oAD5_r5uSdMraJFU_IrnJxu_066s1Dk4SAIPS4mQ

**Body**raw (json)

json

`{
    "id": 1,
    "raceName": "Rotweiller",
    "specie": {"id": 1}
}`

****DELETERaceDelete[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/22
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzE5MzIsImV4cCI6MTY3NDc3MjI5Mn0.848PFFuYJCx05aSwIitGyS6pzVv2ULQT7-0uaspbLTft6_oAD5_r5uSdMraJFU_IrnJxu_066s1Dk4SAIPS4mQ

## **Color**

Add folder description…

****GETColor[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/color/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzI4OTksImV4cCI6MTY3NDc3MzI1OX0.cgcNCkSWdZAFAYwsT6X0gajtozaeGD9C1hw5o6fLiMzrr3glwlLgOIuQ6DgGMK6tidkGKrq-W6cHUGK59UoD-w

****GETColor[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/color/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzI4OTksImV4cCI6MTY3NDc3MzI1OX0.cgcNCkSWdZAFAYwsT6X0gajtozaeGD9C1hw5o6fLiMzrr3glwlLgOIuQ6DgGMK6tidkGKrq-W6cHUGK59UoD-w

****POSTColorStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/color/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzMxODksImV4cCI6MTY3NDc3MzU0OX0.mWPyvtqq1fkXsJUyLU8nhwLMrS0FH1anf3N77wJI0WdFLrYox5rFzjFiX3TvNnINKZ3mG0qx8yeoEfWSrXtJjQ

**Body**raw (json)

json

`{
    "colorName": "Tri-color"
}`

****PUTColorUpdate[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/color/6
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzMxODksImV4cCI6MTY3NDc3MzU0OX0.mWPyvtqq1fkXsJUyLU8nhwLMrS0FH1anf3N77wJI0WdFLrYox5rFzjFiX3TvNnINKZ3mG0qx8yeoEfWSrXtJjQ

**Body**raw (json)

json

`{
    "colorName": "Bi-color",
    "colorHexadecimal": null
}`

****DELETEColorDelete[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/6
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzMxODksImV4cCI6MTY3NDc3MzU0OX0.mWPyvtqq1fkXsJUyLU8nhwLMrS0FH1anf3N77wJI0WdFLrYox5rFzjFiX3TvNnINKZ3mG0qx8yeoEfWSrXtJjQ

## **Size**

Add folder description…

****GETSize[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/size/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzUwNjIsImV4cCI6MTY3NDc3NTQyMn0.nLLrY-BAHnguGAmoq0yAfpfGTfLMY1lIyuNUwq9ouyGzfzQ9069q1q8lguAP0xE5m8FnnJIBM_SblYyIR9l_5w

****GETSize[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/size/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzQzMDYsImV4cCI6MTY3NDc3NDY2Nn0.BQjEtD9NDP4f5DQcQv3QKGuHtzfT9bpeKnZrIGCAx0VWYXR35Iqt0yRPVjP6k_oRhK-rP8PTWc-dNAO-bVG2Vw

****POSTSizeStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/size/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzUzMTUsImV4cCI6MTY3NDc3NTY3NX0.P-uTji8JFa49Nv_mj3w2woiUyl7h_tCxzcQuXA8894T4mk3Dx5wrX4Xubg631gmPXjyG7e9U_vUHnEY4x9Jlog

**Body**raw (json)

json

`{
    "sizeName": "Gigante"
}`

****PUTSizeUpdate[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/size/4
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzUzMTUsImV4cCI6MTY3NDc3NTY3NX0.P-uTji8JFa49Nv_mj3w2woiUyl7h_tCxzcQuXA8894T4mk3Dx5wrX4Xubg631gmPXjyG7e9U_vUHnEY4x9Jlog

**Body**raw (json)

json

`{
    "sizeName": "Grande-Médio"
}`

****DELETESizeDelete[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/size/4
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ3NzUzMTUsImV4cCI6MTY3NDc3NTY3NX0.P-uTji8JFa49Nv_mj3w2woiUyl7h_tCxzcQuXA8894T4mk3Dx5wrX4Xubg631gmPXjyG7e9U_vUHnEY4x9Jlog

## **Ongs**

Add folder description…

****GETCountPets[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/ong/countpets
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ1ODM5MDcsImV4cCI6MTY3NDU4NDI2N30.M425wQ9mXfmWVeykkmDECNkByTu4TppYhbYmGtX8cJVFzAcfyZyXPBsbHSSgHbby9KSCRqEK9t5FtsL4AJFH5g

****GETFeedPets[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/ong/countpets
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ1Mzc3MzIsImV4cCI6MTY3NDUzODA5Mn0.8eMuv6mC7Md5lF44gRDAMPAeZCXJFjW5TjxiLGdCTpxCyUs5mzFK2W1odC7wVBkYwLhGx0IABhbpZ8tU1ylYbQ

## **Adoptions**

Add folder description…

****GETAdoptions[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/adoption/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ1NzQyMTYsImV4cCI6MTY3NDU3NDU3Nn0.MpHZSMNQzUoKfR05OJSfZd6XTbG-GNw3K69VueM9biBwdCU3n8MgfHrySIHoxOyc7lt7HXn52M7lbgvX260vOg

****POSTAdoption[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/adoption/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ1ODM5MDcsImV4cCI6MTY3NDU4NDI2N30.M425wQ9mXfmWVeykkmDECNkByTu4TppYhbYmGtX8cJVFzAcfyZyXPBsbHSSgHbby9KSCRqEK9t5FtsL4AJFH5g

**Body**raw (json)

json

`{
    "userOwner": { "id": 2 },
    "petAdopted": { "id": 2 },
    "userRequestsCode": null,
    "userRequestsDate": null,
    "userAdoptsStatus": null,
    "userAdoptsDate": null,
    "userOwnsDate": null,
    "ownershipActive": false
}`

****GETTest App[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/
```

Add request description…

**Request Headers**

**Authorization**

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhZG1pbi5jb20iLCJpYXQiOjE2NzQ1NTQ3ODAsImV4cCI6MTY3NDU1NTE0MH0.IpcnpZNAZy1mieyyFSzhgpz9Wen4IPqDc8Kcd_c5jE1MR5kpOMgTNEjRL7x3-CtJ_tzyw77I-yMB5idW1Ww4Fw
