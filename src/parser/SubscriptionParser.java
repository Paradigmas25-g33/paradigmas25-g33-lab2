package parser;

import subscription.SingleSubscription;
import subscription.Subscription;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

public class SubscriptionParser extends GeneralParser {

    @Override
    public Subscription parse(String filePath) {
        try {
            String content = readFile(filePath); // Usa el método de GeneralParser
            JSONArray jsonArray = new JSONArray(new JSONTokener(content));
            Subscription subscription = new Subscription();

            // Parsear cada objeto JSON en un SingleSubscription
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String url = jsonObject.getString("url");
                JSONArray paramsArray = jsonObject.getJSONArray("urlParams");
                String urlType = jsonObject.getString("urlType");
                String download = jsonObject.getString("download");

                SingleSubscription singleSubscription = new SingleSubscription(url, null, urlType, download);
                for (int j = 0; j < paramsArray.length(); j++) {
                    singleSubscription.setUlrParams(paramsArray.getString(j));
                }

                subscription.addSingleSubscription(singleSubscription);
            }

            return subscription;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    public static void main(String[] args) {
        SubscriptionParser parser = new SubscriptionParser();
        Subscription subscription = parser.parse(System.getProperty("user.dir") + "/config/subscriptions.json");
        subscription.prettyPrint();
    }
}