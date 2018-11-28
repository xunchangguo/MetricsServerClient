
package io.fabric8.kubernetes.metrics.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListMeta;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "items",
    "kind",
    "metadata"
})
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
public class PodMetricsList implements KubernetesResource<PodMetrics>, KubernetesResourceList<PodMetrics>
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    @JsonPropertyDescription("")
    private String apiVersion = "metrics/v1beta1";
    /**
     * 
     * 
     */
    @JsonProperty("items")
    @JsonPropertyDescription("")
    private List<PodMetrics> items = new ArrayList<PodMetrics>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    @JsonPropertyDescription("")
    private String kind = "PodMetricsList";
    /**
     * 
     * 
     */
    @JsonProperty("metadata")
    @JsonPropertyDescription("")
    private ListMeta metadata;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * 
     * 
     */
    @JsonProperty("items")
    public List<PodMetrics> getItems() {
        return items;
    }

    /**
     * 
     * 
     */
    @JsonProperty("items")
    public void setItems(List<PodMetrics> items) {
        this.items = items;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 
     * 
     */
    @JsonProperty("metadata")
    public ListMeta getMetadata() {
        return metadata;
    }

    /**
     * 
     * 
     */
    @JsonProperty("metadata")
    public void setMetadata(ListMeta metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("apiVersion", apiVersion).append("items", items).append("kind", kind).append("metadata", metadata).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metadata).append(apiVersion).append(items).append(kind).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PodMetricsList) == false) {
            return false;
        }
        PodMetricsList rhs = ((PodMetricsList) other);
        return new EqualsBuilder().append(metadata, rhs.metadata).append(apiVersion, rhs.apiVersion).append(items, rhs.items).append(kind, rhs.kind).isEquals();
    }

}
