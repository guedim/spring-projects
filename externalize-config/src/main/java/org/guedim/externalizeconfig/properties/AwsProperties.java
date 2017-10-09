package org.guedim.externalizeconfig.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "aws")
public class AwsProperties {
    private S3Properties s3;
    private FirehoseProperties firehose;

    public S3Properties getS3() {
        return s3;
    }

    public void setS3(S3Properties s3) {
        this.s3 = s3;
    }

    public FirehoseProperties getFirehose() {
        return firehose;
    }

    public void setFirehose(FirehoseProperties firehose) {
        this.firehose = firehose;
    }

    public static class S3Properties {
        private String bucket;
        private String region;

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

    public static class FirehoseProperties {
        private String deliveryStream;
        private String region;

        public String getDeliveryStream() {
            return deliveryStream;
        }

        public void setDeliveryStream(String deliveryStream) {
            this.deliveryStream = deliveryStream;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }
}
