package data.access;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.kinvey.java.model.KinveyMetaData;

/**
 * Created by Mahmoud Ellawatty on 11/06/2016.
 */
public class RestuarantEntity extends GenericJson {

    @Key("_id")
    private String id;

    @Key("_kmd")
    private KinveyMetaData meta;
    @Key("_acl")
    private KinveyMetaData.AccessControlList acl;


    public RestuarantEntity(){}

}
