package org.alfresco.sample;

import java.io.IOException;

import org.alfresco.service.cmr.repository.NodeService;
import org.springframework.extensions.webscripts.AbstractWebScript;
import org.springframework.extensions.webscripts.WebScriptException;
import org.springframework.extensions.webscripts.WebScriptRequest;
import org.springframework.extensions.webscripts.WebScriptResponse;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonWebscript extends AbstractWebScript
{
    public String hest() {
        return "HESTKO";
    }

    public String Ole() {
        return "....";
    }
    public String Ole1() {
        return "fisk fisko";
    }

    private NodeService nodeService;

    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public void execute(WebScriptRequest req, WebScriptResponse res)
            throws IOException
    {
        try
        {
            // build a json object
            JSONObject obj = new JSONObject();

            // put some data on it
            obj.put("Hello", "World");
            obj.put("Test", hest());
            obj.put("T", Ole1());

            obj.put("NS OK", this.nodeService != null);

            // build a JSON string and send it back
            String jsonString = obj.toString();
            res.getWriter().write(jsonString);
        }
        catch(JSONException e)
        {
            throw new WebScriptException("Unable to serialize JSON");
        }
    }
}