
package io.fabric8.kubernetes.metrics.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Quantity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "usage"
})
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
public class ContainerMetrics implements KubernetesResource
{

    /**
     * 
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("")
    private java.lang.String name;
    /**
     * 
     * 
     */
    @JsonProperty("usage")
    @JsonPropertyDescription("")
    private Map<String, Quantity> usage;

    /**
     * 
     * 
     */
    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    /**
     * 
     * 
     */
    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * 
     * 
     */
    @JsonProperty("usage")
    public Map<String, Quantity> getUsage() {
        return usage;
    }

    /**
     * 
     * 
     */
    @JsonProperty("usage")
    public void setUsage(Map<String, Quantity> usage) {
        this.usage = usage;
    }

    @Override
    public java.lang.String toString() {
        return new ToStringBuilder(this).append("name", name).append("usage", usage).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(usage).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContainerMetrics) == false) {
            return false;
        }
        ContainerMetrics rhs = ((ContainerMetrics) other);
        return new EqualsBuilder().append(name, rhs.name).append(usage, rhs.usage).isEquals();
    }

}
