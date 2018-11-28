package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"log"
	"reflect"
	"strings"
	"time"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	metrics "k8s.io/metrics/pkg/apis/metrics/v1beta1"

	"os"

	"github.com/fabric8io/kubernetes-client/kubernetes-model/pkg/schemagen"
)

type Schema struct {
	NodeMetrics      metrics.NodeMetrics
	NodeMetricsList  metrics.NodeMetricsList
	PodMetrics       metrics.PodMetrics
	PodMetricsList   metrics.PodMetricsList
	ContainerMetrics metrics.ContainerMetrics

	ObjectMeta metav1.ObjectMeta
	TypeMeta   metav1.TypeMeta
}

func main() {
	packages := []schemagen.PackageDescriptor{
		{"k8s.io/metrics/pkg/apis/metrics/v1beta1", "", "io.fabric8.kubernetes.metrics.model", "kubernetes_metrics_"},
		{"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_"},
	}

	typeMap := map[reflect.Type]reflect.Type{
		//		reflect.TypeOf(rapi.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
	}
	schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap)
	if err != nil {
		fmt.Fprintf(os.Stderr, "An error occurred: %v", err)
		return
	}

	args := os.Args[1:]
	if len(args) < 1 || args[0] != "validation" {
		schema.Resources = nil
	}

	b, err := json.Marshal(&schema)
	if err != nil {
		log.Fatal(err)
	}
	result := string(b)
	result = strings.Replace(result, "\"additionalProperty\":", "\"additionalProperties\":", -1)
	var out bytes.Buffer
	err = json.Indent(&out, []byte(result), "", "  ")
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println(out.String())
}
