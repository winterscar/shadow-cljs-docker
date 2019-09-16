# Shadow-cljs in Docker
This repo is a starting point for creating re-frame clojurescript in the browser, without having to install java, npm, etc..

## Usage
```
  ./Invoke-Action [Command]
```

Possible commands are: 
  - *ManageDeps*: Opens the docker container so that you can use npm to add/remove packages
  - *InstallDeps*: Runs `npm i` in the container
  - *Build*: Builds production artifacts for deployment
  - *Run*: Starts a hot-reload dev server

## Writing Code
In order to use the dev server, you will need to use the Remote Explorer functionality in
VS Code to connect to the docker container and make your changes. Making changes to the local files does not trigger a hot reload for some reason.


The core app is pre-loaded with a simple re-frame example as a starting point. 