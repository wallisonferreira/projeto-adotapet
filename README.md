
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
    "username":"user1",
    "email":"user1@user1.com",
    "password":"user1"
}`

## **Users**

****GET Users****

```
https://localhost:9000/config/user/
```

**Request Headers**

**Content-Type** application/json

**Authorization** Bearer <token>

****GET User****

```
https://localhost:9000/config/user/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****GETSearchUserByRole[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/config/user/searchRole?term=ROLE_ADMIN
```

Add request description…

**Request Headers**

**Content-Type**

application/json

**Authorization**

Bearer <token>

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

Bearer <token>

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

Bearer <token>

**Body**raw (json)

json

`{
    "name": "Daniel Right",
    "email": "daniel@mail.cobit",
    "password":"user"
}`

****PUTUserUpdate[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/config/user/13
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>
**Body**raw (json)

View More

json

`{
    "name": "User1",
    "email": "user1@user1.com",
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

Bearer <token>

****GETPet[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****GETPetSearch[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/pet/search?term=a
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

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

Bearer <token>

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

Bearer <token>

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

Bearer <token>

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

Bearer <token>

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

Bearer <token>

## **Specie**

Add folder description…

****GETSpecie[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/specie/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****GETSpecie[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/specie/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****POSTSpecieStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/specie/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

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

Bearer <token>

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

Bearer <token>

## **Race**

Add folder description…

****GETRace[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****GETRace[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****GETRaceSearch[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/search?term=York
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

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

Bearer <token>

****POSTRaceStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/race/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

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

Bearer <token>

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

Bearer <token>

## **Color**

Add folder description…

****GETColor[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/color/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****GETColor[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/color/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****POSTColorStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/color/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

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

Bearer <token>

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

Bearer <token>

## **Size**

Add folder description…

****GETSize[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/size/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****GETSize[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/size/1
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****POSTSizeStore[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/size/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

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

Bearer <token>

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

Bearer <token>

## **Ongs**

Add folder description…

****GETCountPets[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/ong/countpets
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****GETFeedPets[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/ong/countpets
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

## **Adoptions**

Add folder description…

****GETAdoptions[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/adoption/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

****POSTAdoption[Open Request](https://desktop.postman.com/?desktopVersion=10.8.0&userId=1320414&teamId=0)**

```
https://localhost:9000/adoption/
```

Add request description…

**Request Headers**

**Authorization**

Bearer <token>

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

Bearer <token>
