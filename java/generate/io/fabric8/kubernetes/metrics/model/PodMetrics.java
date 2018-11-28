
package io.fabric8.kubernetes.metrics.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
    "containers",
    "kind",
    "metadata",
    "timestamp",
    "window"
})
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
public class PodMetrics implements HasMetadata
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    @JsonPropertyDescription("")
    private java.lang.String apiVersion = "metrics/v1beta1";
    /**
     * 
     * 
     */
    @JsonProperty("containers")
    @JsonPropertyDescription("")
    private List<ContainerMetrics> containers = new ArrayList<ContainerMetrics>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    @JsonPropertyDescription("")
    private java.lang.String kind = "PodMetrics";
    /**
     * 
     * 
     */
    @JsonProperty("metadata")
    @JsonPropertyDescription("")
    private ObjectMeta metadata;
    /**
     * 
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("")
    private String timestamp;
    /**
     * 
     * 
     */
    @JsonProperty("window")
    @JsonPropertyDescription("")
    private String window;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * 
     * 
     */
    @JsonProperty("containers")
    public List<ContainerMetrics> getContainers() {
        return containers;
    }

    /**
     * 
     * 
     */
    @JsonProperty("containers")
    public void setContainers(List<ContainerMetrics> containers) {
        this.containers = containers;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    /**
     * 
     * 
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * 
     * 
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * 
     * 
     */
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * 
     */
    @JsonProperty("window")
    public String getWindow() {
        return window;
    }

    /**
     * 
     * 
     */
    @JsonProperty("window")
    public void setWindow(String window) {
        this.window = window;
    }

    @Override
    public java.lang.String toString() {
        return new ToStringBuilder(this).append("apiVersion", apiVersion).append("containers", containers).append("kind", kind).append("metadata", metadata).append("timestamp", timestamp).append("window", window).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metadata).append(apiVersion).append(kind).append(containers).append(window).append(timestamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PodMetrics) == false) {
            return false;
        }
        PodMetrics rhs = ((PodMetrics) other);
        return new EqualsBuilder().append(metadata, rhs.metadata).append(apiVersion, rhs.apiVersion).append(kind, rhs.kind).append(containers, rhs.containers).append(window, rhs.window).append(timestamp, rhs.timestamp).isEquals();
    }

}
