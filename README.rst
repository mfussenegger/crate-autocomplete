=========================
Crate SQL Auto-Completion
=========================

This is a plugin for `Crate <https://crate.io>`_ (`Github Link
<https://github.com/crate/crate>`_) that adds an additional REST Endpoint which
provides auto-complete functionality for SQL statements.


Compatibility
=============

+---------------+----------------+
| Crate Version | Plugin Version |
+===============+================+
|        0.54.X |          0.1.0 |
+---------------+----------------+

Installation
============

Releases are available via `JitPack
<https://jitpack.io/#mfussenegger/crate-autocomplete/>`_.

Download the JAR and put it into the ``plugins`` folder in your crate installation::

    curl https://jitpack.io/com/github/mfussenegger/crate-autocomplete/0.1.0/crate-autocomplete-0.1.0.jar -o /path/to/crate/plugins/crate-autocomplete.jar

And restart crate.

Remember to make sure that the user the Crate process is running under needs to
have read permission on the jar file in order to be able to load the plugin.

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

Run ``./gradlew idea`` to generate the IntelliJ project files and start development.

In order to generate the jar file, run ``./gradlew jar``.
