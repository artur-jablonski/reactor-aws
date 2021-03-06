package com.ravenpack.content.commons.aws.reactor;

import com.ravenpack.content.commons.aws.reactor.ddb.RxDynamo;
import com.ravenpack.content.commons.aws.reactor.ddb.RxDynamoImpl;
import com.ravenpack.content.commons.aws.reactor.s3.RxS3;
import com.ravenpack.content.commons.aws.reactor.s3.RxS3Impl;
import com.ravenpack.content.commons.aws.reactor.sqs.RxSqs;
import com.ravenpack.content.commons.aws.reactor.sqs.RxSqsImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReactorAWS
{

    public static RxDynamo dynamo(DynamoDbAsyncClient ddbClient)
    {
        return new RxDynamoImpl(ddbClient);
    }

    public static RxSqs sqs(SqsAsyncClient sqsClient)
    {
        return RxSqsImpl.builder().client(sqsClient).build();
    }

    public static RxS3 s3(S3AsyncClient s3Client)
    {
        return new RxS3Impl(s3Client);
    }

}
