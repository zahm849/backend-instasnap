# backend-instasnap

Présentation des apis à mettre en place par le back end

         I.            Les apis concernant la gestion des utilisateurs
'''
utilisateurs/new
utilisateurs/update/{id}
utilisateurs/delete/{id}
utilisateurs/all
utilisateurs/getUserById/{id}

security/login/{username}/{password}
security/logout
'''

       II.            Les apis concernant les publications
'''
publications/new
publications/update/{id}
publications/deleteManuel/{id}
publications/deleteAuto/{id}
publications/getAllByUser/{id}
publications/getTopTen
publications/getPublicationById/{id}
publications/like/new
publications/like/getAll
publications/like/delete/{id}
publications/commentaire/new
publications/commentaire/getAll
publications/commentaire/delete/{id}
'''
## Context

L'url de base de l'api ci-dessous:

```
context = http://184.72.152.79:8080/api/v1
```

Chaque appel de service de l' api se fait avec

```
context + url
```

## Inscription
```javascript
{
  "url": "/api/v1/utilisateurs/new",
  "method": "POST",
  "headers": [],
  "params": [],
  "bodyJson": {
    "user": {
      "id": null, 
      "nom": "",
      "prenom": "",
      "profil": "",
      "email": "",
      "username": "", 
      "password": ""
    }
  },
  " protocol": "http"
}
```

## Login

```json
{
  "url": "/api/v1/security/login",
  "method": "POST",
  "headers": [],
  "params": [],
  "bodyJson": {
    "username": "",
    "password": ""
  },
  "protocol": "http"
}
```

# Suppression d'utilisateur

```json
{
  "url": "/api/v1/publications/delete/{id}",
  "method": "DELETE",
  "headers": [],
  "params": [
    {
      "key": "id",
      "value": "0"
    }
  ],
  "bodyJson": "",
  "protocol": "http"
}
```


{
"url": "/api/v1/commentaires/getCommentaireById/{id}",
"method": "GET",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "",
"description": "CommentaireController#getCommentaireById",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757515
},
{
"url": "/api/v1/commentaires/update/{id}",
"method": "PUT",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "{\n  \"commentaire\": {\n    \"id\": 0,\n    \"contenu\": \"\",\n    \"publication\": {\n      \"id\": 0,\n      \"libelle\": \"\",\n      \"url\": \"\",\n      \"etat\": true,\n      \"nombre_vue\": 0,\n      \"last_seen\": 1653996757655,\n      \"user\": {\n        \"id\": 0,\n        \"nom\": \"\",\n        \"prenom\": \"\",\n        \"profil\": \"\",\n        \"email\": \"\",\n        \"username\": \"\",\n        \"password\": \"\",\n        \"createdAt\": 1653996757695,\n        \"updatedAt\": 1653996757696\n      },\n      \"createdAt\": 1653996757696,\n      \"updatedAt\": 1653996757696\n    },\n    \"user\": {\n      \"id\": 0,\n      \"nom\": \"\",\n      \"prenom\": \"\",\n      \"profil\": \"\",\n      \"email\": \"\",\n      \"username\": \"\",\n      \"password\": \"\",\n      \"createdAt\": 1653996757697,\n      \"updatedAt\": 1653996757697\n    }\n  },\n  \"publication\": 0,\n  \"user\": 0\n}",
"description": "CommentaireController#updateCommentaire",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757516
},
{
"url": "/api/v1/publications/new",
"method": "POST",
"headers": [],
"params": [],
"bodyJson": "{\n  \"publication\": {\n    \"id\": 0,\n    \"url\": \"\",\n    \"libelle\": \"\",\n    \"nombre_vue\": 0,\n    \"last_seen\": 1653996757708,\n    \"etat\": true\n  },\n  \"user\": 0\n}",
"description": "PublicationController#CreatePublication",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757701
},
{
"url": "/api/v1/utilisateurs/delete/{id}",
"method": "DELETE",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "",
"description": "UserController#deleteUser",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757708
},
{
"url": "/api/v1/commentaires/new",
"method": "POST",
"headers": [],
"params": [],
"bodyJson": "{\n  \"commentaire\": {\n    \"id\": 0,\n    \"contenu\": \"\",\n    \"publication\": {\n      \"id\": 0,\n      \"libelle\": \"\",\n      \"url\": \"\",\n      \"etat\": true,\n      \"nombre_vue\": 0,\n      \"last_seen\": 1653996757713,\n      \"user\": {\n        \"id\": 0,\n        \"nom\": \"\",\n        \"prenom\": \"\",\n        \"profil\": \"\",\n        \"email\": \"\",\n        \"username\": \"\",\n        \"password\": \"\",\n        \"createdAt\": 1653996757714,\n        \"updatedAt\": 1653996757715\n      },\n      \"createdAt\": 1653996757715,\n      \"updatedAt\": 1653996757715\n    },\n    \"user\": {\n      \"id\": 0,\n      \"nom\": \"\",\n      \"prenom\": \"\",\n      \"profil\": \"\",\n      \"email\": \"\",\n      \"username\": \"\",\n      \"password\": \"\",\n      \"createdAt\": 1653996757717,\n      \"updatedAt\": 1653996757717\n    }\n  },\n  \"publication\": 0,\n  \"user\": 0\n}",
"description": "CommentaireController#CreateCommentaire",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757710
},
{
"url": "/api/v1/utilisateurs/getUserById/{id}",
"method": "GET",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "",
"description": "UserController#getUserById",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757717
},
{
"url": "/api/v1/utilisateurs/new",
"method": "POST",
"headers": [],
"params": [],
"bodyJson": "{\n  \"user\": {\n    \"id\": 0,\n    \"nom\": \"\",\n    \"prenom\": \"\",\n    \"profil\": \"\",\n    \"email\": \"\",\n    \"username\": \"\",\n    \"password\": \"\"\n  }\n}",
"description": "UserController#CreateUser#Cet api permet d'enregistrer un utilisateur",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757719
},
{
"url": "/api/v1/utilisateurs/update/{id}",
"method": "PUT",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "{\n  \"user\": {\n    \"id\": 0,\n    \"nom\": \"\",\n    \"prenom\": \"\",\n    \"profil\": \"\",\n    \"email\": \"\",\n    \"username\": \"\",\n    \"password\": \"\"\n  }\n}",
"description": "UserController#updateUser",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757739
},
{
"url": "/api/v1/publications/liker/new",
"method": "POST",
"headers": [],
"params": [],
"bodyJson": "{\n  \"liker\": {\n    \"id\": 0,\n    \"publication\": {\n      \"id\": 0,\n      \"libelle\": \"\",\n      \"url\": \"\",\n      \"etat\": true,\n      \"nombre_vue\": 0,\n      \"last_seen\": 1653996757745,\n      \"user\": {\n        \"id\": 0,\n        \"nom\": \"\",\n        \"prenom\": \"\",\n        \"profil\": \"\",\n        \"email\": \"\",\n        \"username\": \"\",\n        \"password\": \"\",\n        \"createdAt\": 1653996757746,\n        \"updatedAt\": 1653996757746\n      },\n      \"createdAt\": 1653996757746,\n      \"updatedAt\": 1653996757746\n    },\n    \"user\": {\n      \"id\": 0,\n      \"nom\": \"\",\n      \"prenom\": \"\",\n      \"profil\": \"\",\n      \"email\": \"\",\n      \"username\": \"\",\n      \"password\": \"\",\n      \"createdAt\": 1653996757747,\n      \"updatedAt\": 1653996757747\n    }\n  },\n  \"publication\": 0,\n  \"user\": 0\n}",
"description": "PublicationController#CreateLiker",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757741
},
{
"url": "/api/v1/utilisateurs/all",
"method": "GET",
"headers": [],
"params": [],
"bodyJson": "",
"description": "UserController#listUsers",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757748
},
{
"url": "/api/v1/publications/update/{id}",
"method": "PUT",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "{\n  \"publication\": {\n    \"id\": 0,\n    \"url\": \"\",\n    \"libelle\": \"\",\n    \"nombre_vue\": 0,\n    \"last_seen\": 1653996757750,\n    \"etat\": true\n  },\n  \"user\": 0\n}",
"description": "PublicationController#updatePublication",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757749
},
{
"url": "/api/v1/commentaires/delete/{id}",
"method": "DELETE",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "",
"description": "CommentaireController#deleteCommentaire",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757750
},
{
"url": "/api/v1/publications/getTopTen",
"method": "GET",
"headers": [],
"params": [],
"bodyJson": "",
"description": "PublicationController#listTopTenPublications",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757751
},
{
"url": "/api/v1/commentaires/getCommentaireByUser/{id}",
"method": "GET",
"headers": [],
"params": [
{
"key": "user",
"value": "0"
}
],
"bodyJson": "",
"description": "CommentaireController#getCommentaireByUser",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757751
},
{
"url": "/api/v1/likers/all",
"method": "GET",
"headers": [],
"params": [],
"bodyJson": "",
"description": "LikerController#listLikers",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757753
},
{
"url": "/api/v1/publications/getPublicationById/{id}",
"method": "GET",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "",
"description": "PublicationController#getPublicationById",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757753
},
{
"url": "/api/v1/utilisateurs/{page}/{pageSize}",
"method": "GET",
"headers": [],
"params": [
{
"key": "page",
"value": "0"
},
{
"key": "pageSize",
"value": "0"
}
],
"bodyJson": "",
"description": "UserController#getAllContact",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757753
},
{
"url": "/api/v1/publications/all",
"method": "GET",
"headers": [],
"params": [],
"bodyJson": "",
"description": "PublicationController#listPublications",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757756
},
{
"url": "/api/v1/commentaires/all",
"method": "GET",
"headers": [],
"params": [],
"bodyJson": "",
"description": "CommentaireController#listCommentaires",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757756
},
{
"url": "/api/v1/likers",
"method": "POST",
"headers": [],
"params": [],
"bodyJson": "{\n  \"liker\": {\n    \"id\": 0,\n    \"publication\": {\n      \"id\": 0,\n      \"libelle\": \"\",\n      \"url\": \"\",\n      \"etat\": true,\n      \"nombre_vue\": 0,\n      \"last_seen\": 1653996757758,\n      \"user\": {\n        \"id\": 0,\n        \"nom\": \"\",\n        \"prenom\": \"\",\n        \"profil\": \"\",\n        \"email\": \"\",\n        \"username\": \"\",\n        \"password\": \"\",\n        \"createdAt\": 1653996757759,\n        \"updatedAt\": 1653996757759\n      },\n      \"createdAt\": 1653996757759,\n      \"updatedAt\": 1653996757759\n    },\n    \"user\": {\n      \"id\": 0,\n      \"nom\": \"\",\n      \"prenom\": \"\",\n      \"profil\": \"\",\n      \"email\": \"\",\n      \"username\": \"\",\n      \"password\": \"\",\n      \"createdAt\": 1653996757760,\n      \"updatedAt\": 1653996757760\n    }\n  },\n  \"publication\": 0,\n  \"user\": 0\n}",
"description": "LikerController#CreateLiker",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757756
},
{
"url": "/api/v1/likers/{id}",
"method": "GET",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "",
"description": "LikerController#getLikerById",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757760
},
{
"url": "/api/v1/likers/{id}",
"method": "PUT",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "{\n  \"liker\": {\n    \"id\": 0,\n    \"publication\": {\n      \"id\": 0,\n      \"libelle\": \"\",\n      \"url\": \"\",\n      \"etat\": true,\n      \"nombre_vue\": 0,\n      \"last_seen\": 1653996757765,\n      \"user\": {\n        \"id\": 0,\n        \"nom\": \"\",\n        \"prenom\": \"\",\n        \"profil\": \"\",\n        \"email\": \"\",\n        \"username\": \"\",\n        \"password\": \"\",\n        \"createdAt\": 1653996757766,\n        \"updatedAt\": 1653996757766\n      },\n      \"createdAt\": 1653996757766,\n      \"updatedAt\": 1653996757766\n    },\n    \"user\": {\n      \"id\": 0,\n      \"nom\": \"\",\n      \"prenom\": \"\",\n      \"profil\": \"\",\n      \"email\": \"\",\n      \"username\": \"\",\n      \"password\": \"\",\n      \"createdAt\": 1653996757767,\n      \"updatedAt\": 1653996757767\n    }\n  },\n  \"publication\": 0,\n  \"user\": 0\n}",
"description": "LikerController#updateLiker",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757762
},
{
"url": "/api/v1/likers/{id}",
"method": "DELETE",
"headers": [],
"params": [
{
"key": "id",
"value": "0"
}
],
"bodyJson": "",
"description": "LikerController#deleteLiker",
"moduleName": "instasnap",
"framework": "Spring MVC",
"protocol": "http",
"id": "",
"ts": 1653996757767
},


 

