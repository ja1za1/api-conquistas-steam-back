# api-conquistas-steam-back
Essa API foi desenvolvida para obter a quantidade de usuários que têm certa quantidade de conquistas em jogos da Steam.

## Requisitos
- Java 17
- PostgreSQL 14
- Pgadmin 4 (para restauração do banco de dados)

## Instalação

### Restaurando banco de dados

1. Baixe ou clone esse repositório com:
   ```
   git pull https://github.com/ja1za1/api-conquistas-steam-back
   ```
2. Abra o Pgadmin, crie um banco qualquer com nome de `steamIds` e nomeie o usuário `postgres` como dono.
   
   ![Screenshot 0](assets/screenshot0.png)
   
3. Clique com botão direito no banco criado e depois clique em Restore... e clique na pasta destacada em vermelho.
   
   ![Screenshot 1](assets/screenshot1.png)

4. Navegue até a pasta do projeto e vá para o diretório `src/main/bd` e selecione o arquivo de backup do banco e clique em Restore.
   
   ![Screenshot 2](assets/screenshot2.png)

### Executando a API

Navegue até a pasta `src/main/jar`, abra o terminal e digite o comando:

```
java -jar api-steam-v1.jar
```

Caso a mensagem "Esta rodando" apareça no terminal, a API foi executada com sucesso no endereço: `http://localhost:8080` e está pronta para receber requisições.

   ![Screenshot 3](assets/screenshot3.png)

Obs.: Por motivos didáticos, o arquivo jar foi compilado com usuário e senha do banco respectivamente: postgres e 123456789. Portanto, caso a senha do seu usuário postgres não seja essa, não funcionará.

## Documentação API

A api é bem simples, contando com apenas 3 endpoints:

- Retorna as informações de um determinado jogo:
  
  ```
   GET http://localhost:8080/api/info/{appid}
  ```
  - Parâmetros
    - `appid: String` : O appid do jogo da steam.
      
  - Resposta
    - Uma possível resposta para a requisição acima:
      
      ```
      {
       "success": true,
       "message": "OK",
       "game": {
           "id": 26,
           "name": "Borderlands 2",
           "appid": "49520",
           "description": "A atualização Ultimate Vault Hunter permite que você aproveite ao máximo a experiência de Borderlands 2.",
           "achievementsAmount": 75,
           "achievements": [
               {
                   "name": "Achievement_1",
                   "displayName": "First One's Free",
                   "hidden": true,
                   "description": null,
                   "icon": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/apps/49520/d32ad4c7edb12bca7affc57e213d29d8820936dc.jpg",
                   "iconGray": null
               },
               {
                   "name": "Achievement_2",
                   "displayName": "Dragon Slayer",
                   "hidden": true,
                   "description": null,
                   "icon": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/apps/49520/87a8a3acc1acfb7aac19ee0859bbff494a62f2aa.jpg",
                   "iconGray": null
               },
               {
                   "name": "Achievement_3",
                   "displayName": "A Road Less Traveled",
                   "hidden": true,
                   "description": null,
                   "icon": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/apps/49520/7f8957b0d85584a403962d21013e6baeb31571b2.jpg",
                   "iconGray": null
               },
               {
                   "name": "Achievement_4",
                   "displayName": "New In Town",
                   "hidden": true,
                   "description": null,
                   "icon": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/apps/49520/4207845723542a0798ecaede1e34c0655f05df68.jpg",
                   "iconGray": null
               },
               {
                   "name": "Achievement_5",
                   "displayName": "An Old Flame",
                   "hidden": true,
                   "description": null,
                   "icon": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/apps/49520/eef2ce58e116ea0cd1e5b9d6a82968ebd22b843d.jpg",
                   "iconGray": null
               },
               {
                   "name": "Achievement_6",
                   "displayName": "No Man Left Behind",
                   "hidden": true,
                   "description": null,
                   "icon": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/apps/49520/46fd68f506f2ee8c3f8019ca49c6bc735a7f3f7a.jpg",
                   "iconGray": null
               }
           ]
       }
      }
      ```
      - Parâmetros da resposta:
         - `success: Boolean` : Indica se a requisição retornou código `200`.
         - `message: String` : Mensagem indicando o status ou algum possível erro da requisição.
         - `game: Object` : Objeto contendo as informações do jogo.
