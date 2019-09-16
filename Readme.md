# Shadow-cljs in Docker
This repo is a starting point for creating re-frame clojurescript in the browser, without having to install java, npm, etc..

## Getting started
1. Clone this repo
2. Build the docker base image with `docker build .` 
3. Install npm deps with `Invoke-Action InstallDeps`
4. Start the dev server with `Invoke-Action Run`
5. Use VS code to connect to the docker container, and start making changes to code in `/app`

## Usage
```
  ./Invoke-Action [Command]
```

Possible commands are: 
  - __ManageDeps__: Opens the docker container so that you can use npm to add/remove packages
  - __InstallDeps__: Runs `npm i` in the container
  - __Build__: Builds production artifacts for deployment
  - __Run__: Starts a hot-reload dev server

## Writing Code
In order to use the dev server, you will need to use the Remote Explorer functionality in
VS Code to connect to the docker container and make your changes. Making changes to the local files does not trigger a hot reload for some reason.


The core app is pre-loaded with a simple re-frame example as a starting point. 