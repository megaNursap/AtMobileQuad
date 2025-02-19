package utils.factory;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

public class DynamoDeleteCampPOI {
    public static void deletePOI(String poiid){
        AWSCredentials awsCredentials = new AWSCredentials() {
            @Override
            public String getAWSAccessKeyId() {
                return "AccessKeyId";
            }
            @Override
            public String getAWSSecretKey() {
                return "SecretKey";
            }
        };
        String tableName = "POIApp.poi-staging";
        AWSStaticCredentialsProvider cred = new AWSStaticCredentialsProvider(awsCredentials);
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withCredentials(cred).withRegion("ap-southeast-1").build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(tableName);
        try {
            DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("id", poiid).withReturnValues(ReturnValue.ALL_OLD);
            DeleteItemOutcome outcome = table.deleteItem(deleteItemSpec);
//             Check the response.
            System.out.println(outcome);
            System.out.println("Printing item that was deleted...");
        }
        catch (Exception e) {
            System.err.println("Error deleting item in " + tableName);
            System.err.println(e.getMessage());
        }
    }
}
