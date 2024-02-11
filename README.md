# Movies-Heaven
Un projet Web qui fournit une plateforme de location de films. Vous pouvez trouver le film souhaité en fonction du nom du film, du genre, de l'année de production, etc.

# Technologies utilisées
Combinant <strong>Node.js</strong> pour le côté serveur, <strong>Tomcat</strong> en tant que serveur HTTP, et <strong>React.js</strong> pour la construction de l'interface utilisateur réactive. 
Le développement s'est effectué principalement dans <strong>Visual Studio Code</strong> pour la partie frontend et <strong>Apache NetBeans</strong> pour le backend. 
La gestion de la base de données a été facilitée par l'utilisation de <strong>MySQL Workbench</strong>. 

#  Guide d'utilisation

## Base de donnée
1. Utilisez pgAdmin
2. Executer les fichiers de création et peupler les tables de la base de donnée

## Backend
1. Ouvrir le projet sur "NetBeans"
2. Ouivrir le fichier "server.java"
3. modifier ces properties:
   ```bash
   private static final String urlServeur=""
   private static final String identifiant=""
   private static final String motDePasse="" 
   ```
4. executer le fichier "ServletUserInfo"

## Frontend
1. Ouvrire Visual Studio Code
2. modifier le port partout ou il y a un lien http pour le localhost dans le dossier "component"
3. lancer le projet
4. installer les dépendances:
   ```bash
   npm install
   npm install react react-dom --save
   ```
5. pour générer une version optimisée pour la production:
   ```bash
   npm run build
   ```
6. lancer l'app:
    ```bash
    npm run dev
    ```
