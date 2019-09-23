# Shadow-cljs in Docker
This repo is a starting point for creating re-frame clojurescript in the browser, without having to install java, npm, etc..
The core app is pre-loaded with a simple re-frame example as a starting point. 

## Getting started
1. Clone this repo
2. Start visual studio code with `code .` and click "Reopen in container" when prompted.
4. Start Calva with ctrl+shift+p >Jack-in

Calva will start and connect you to a repl. Make sure to specify you want to use the :app workspace

## Development
All development happens from within VS Code. Use the integrated terminal to install npm packages and calva as your repl. 

## Deployment
You can build deployment artifacts by using the npm script `release`