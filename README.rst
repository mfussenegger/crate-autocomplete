=========================
Crate SQL Auto-Completion
=========================

This is a plugin for `Crate <https://crate.io>`_ (`Github Link
<https://github.com/crate/crate>`_) that adds an additional REST Endpoint which
provides auto-complete functionality for SQL statements.


Requirements
============

Crate 0.45.X (will probably work with newer versions too)

Installation
============

Change to the folder where crate is installed and use ``bin/plugin`` to install the plugin::

    bin/plugin -u http://dl.bintray.com/mfussenegger/maven/crate-autocomplete.jar -i mfussenegger/crate-autocomplete

And restart crate.

Usage
=====

This plugin adds a new REST endpoint to crate which is reachable under ``/_sql_complete``.

Incomplete SQL statements can be sent to this endpoint using the ``POST``
method. The result will be in JSON format and contain a list of possible
completions as well as a start index indicates at which position of the sent
statement the completions start::

    curl -XPOST localhost:4200/_sql_complete -d '{"stmt": "select n"}'


Development
===========


Development currently depends on a jar file of Crate. This Jar file isn't
available online yet but can be built by cloning the `crate
<https://github.com/crate/crate>`_ repository and running ``./gradlew fatJar``

Then copy the jar from ``<crate-folder>/app/build/libs/crate-app.jar`` to
``<crate-autocomplete-folder>/libs/`` and run ``./gradlew idea``
