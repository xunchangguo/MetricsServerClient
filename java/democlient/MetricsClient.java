import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import io.fabric8.kubernetes.metrics.model.NodeMetrics;
import io.fabric8.kubernetes.metrics.model.NodeMetricsList;
import io.fabric8.kubernetes.metrics.model.PodMetrics;
import io.fabric8.kubernetes.metrics.model.PodMetricsList;
import okhttp3.Request;

/**
 * @author Administrator
 *
 */
public class MetricsClient extends OperationSupport {
	
	public MetricsClient(KubernetesClient client) {
		super(HttpClientUtils.createHttpClient(client.getConfiguration()), client.getConfiguration(),
				"metrics.k8s.io", "v1beta1", null, null, null);
	}

	public void getNodeMetrics() {
		try {
			URL targetUrl = new URL(URLUtils.join(config.getMasterUrl().toString(), "apis", "metrics.k8s.io", "v1beta1", "nodes"));
			Request.Builder requestBuilder = new Request.Builder().get().url(targetUrl);
			NodeMetricsList metricsList =  handleResponse(requestBuilder,  NodeMetricsList.class);
			
//			NodeMetricsList metricsList = handleGet(targetUrl, NodeMetricsList.class);
			List<NodeMetrics> items = metricsList.getItems();
			for (NodeMetrics item : items) {
				System.out.println(item);
			}
		} catch (KubernetesClientException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPodMetrics() {
		try {
			URL targetUrl = new URL(URLUtils.join(config.getMasterUrl().toString(), "apis", "metrics.k8s.io", "v1beta1", "pods"));
			Request.Builder requestBuilder = new Request.Builder().get().url(targetUrl);
			PodMetricsList metricsList =  handleResponse(requestBuilder,  PodMetricsList.class);
			
			List<PodMetrics> items = metricsList.getItems();
			for (PodMetrics item : items) {
				System.out.println(item);
			}
		} catch (KubernetesClientException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
