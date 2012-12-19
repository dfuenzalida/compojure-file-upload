This is a basic File upload example project using Compojure.

Adapted from https://gist.github.com/562624 by https://github.com/nikolaplejic

Updated the versions of the libraries referenced on project.clj because many were outdated by now.

Run with:

$ lein deps
$ lein repl

lein> (use 'fileupload.core)
lein> (start-app)

