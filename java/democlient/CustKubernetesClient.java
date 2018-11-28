import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class CustKubernetesClient extends DefaultKubernetesClient {

	public CustKubernetesClient() throws KubernetesClientException {
		super();
	}

	public CustKubernetesClient(Config config) throws KubernetesClientException {
		super(config);
	}

	public CustKubernetesClient(OkHttpClient httpClient, Config config) throws KubernetesClientException {
		super(httpClient, config);
	}

	public CustKubernetesClient(String masterUrl) throws KubernetesClientException {
		super(masterUrl);
	}
	
	public void getNodeMetrics() throws IOException {
		URL targetUrl = new URL(URLUtils.join(getMasterUrl().toString(), "apis", "metrics.k8s.io", "v1beta1", "nodes"));
		Request.Builder requestBuilder = new Request.Builder().get().url(targetUrl);
		Request request = requestBuilder.build();
		Response response = getHttpClient().newCall(request).execute();
		String res = IOUtils.toString(response.body().byteStream());
		System.out.println(res);
	}

}
