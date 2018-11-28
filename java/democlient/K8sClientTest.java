import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class K8sClientTest {

	public static void main(String[] args) throws Exception {
		Config config = new ConfigBuilder().withMasterUrl("https://172.17.81.55:6443").withTrustCerts(true).withOauthToken("eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJ0aWxsZXItdG9rZW4tbXFrYzUiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoidGlsbGVyIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiYWVhMmFmOTEtNmVhZS0xMWU4LTgzZDQtZmExNjNlYmNhYzI0Iiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50Omt1YmUtc3lzdGVtOnRpbGxlciJ9.vm6ItFKltqZP7oLAUjSA_6r87h1Y6_dPLhWzAPJKXGmitU35eE9vPTE_BpEgMpPGeOoletI3k9C2KGwOylzpda-d-E2w4Wc-fZRTdWCBVa3Noj_dW61HpQZT3vCbHbpm9y6MUeBWCzY2dHr1pFBvQB6CeSdiSka0_PdS7X6pe_JtNdxugFGfjLK3cvWEOHRC42-FEM6vSLo8uty22-Hg0depmdJ2Jahb9o508UckqO20fHgfFgyfdSQNGVEvlwPdzvqyvM9txHJveQkp13vYShNDFVXcweAdd3ukfMmAZkvtGkEG2HVjfTxdfTbfAM3ZoI0tJYJTwvABKch7L2tH1A").build();
//		Config config = new ConfigBuilder().withMasterUrl("https://172.17.87.35:6443").withTrustCerts(true).withOauthToken("ecf6771fe444cc7c").build();
//		Config config = new ConfigBuilder().withMasterUrl("https://172.17.81.55:6443").withTrustCerts(true).withUsername("admin").withPassword("admin").build();
		KubernetesClient k8sClient = new DefaultKubernetesClient(config);
//		CustKubernetesClient k8sClient = new CustKubernetesClient(config);
//		k8sClient.getNodeMetrics();
		MetricsClient mclient = new MetricsClient(k8sClient);
		mclient.getNodeMetrics();
		System.out.println("-------------");
		mclient.getPodMetrics();
		k8sClient.close();
		
	}

}
