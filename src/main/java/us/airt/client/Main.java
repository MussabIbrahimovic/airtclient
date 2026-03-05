package us.airt.client;

public final class Main {
    public static void main(String[] args) {
        AirtClient client = new AirtClient();
        client.bootstrap();
        System.out.println("AIRT.US bootstrap complete. Modules registered: " + client.moduleManager().all().size());
    }
}
