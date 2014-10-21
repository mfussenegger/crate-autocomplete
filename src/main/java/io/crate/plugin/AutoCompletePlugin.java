package io.crate.plugin;

import io.crate.autocomplete.RestSQLAutoCompleteAction;
import io.crate.autocomplete.SQLAutoCompleteAction;
import io.crate.autocomplete.TransportSQLAutoCompleteAction;
import org.elasticsearch.action.ActionModule;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.rest.RestModule;

public class AutoCompletePlugin extends AbstractPlugin {

    @Override
    public String name() {
        return "sql-auto-complete";
    }

    @Override
    public String description() {
        return "SQL auto completion for crate";
    }

    public void onModule(RestModule restModule) {
        restModule.addRestAction(RestSQLAutoCompleteAction.class);
    }

    public void onModule(ActionModule actionModule) {
        actionModule.registerAction(SQLAutoCompleteAction.INSTANCE, TransportSQLAutoCompleteAction.class);
    }
}
