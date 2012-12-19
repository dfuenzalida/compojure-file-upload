This is a basic File upload example project using Compojure.

Adapted from https://gist.github.com/562624 by https://github.com/nikolaplejic

Updated the versions of the libraries referenced on project.clj because many were outdated by now.

Run with:

```
$ lein deps
$ lein repl

user=> (use 'fileupload.core)
nil
user=> (start-app)
...
2012-12-18 22:25:59.660::INFO:  jetty-6.1.14
2012-12-18 22:25:59.678::INFO:  Started SocketConnector@0.0.0.0:8000
...
```
