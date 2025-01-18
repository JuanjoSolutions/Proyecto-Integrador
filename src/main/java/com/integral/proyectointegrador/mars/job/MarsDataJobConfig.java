package com.integral.proyectointegrador.mars.job;

import com.integral.proyectointegrador.mars.model.MarsSensorData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.support.BeanPropertyRowMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;



@Configuration
public class MarsDataJobConfig {
    @Bean
    public JdbcCursorItemReader<MarsSensorData> reader(DataSource dataSource) {
        JdbcCursorItemReader<MarsSensorData> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT * FROM mars_sensor_data");
        reader.setRowMapper(new BeanPropertyRowMapper<>(MarsSensorData.class));
        return reader;
    }

    @Bean
    public ItemProcessor<MarsSensorData, MarsSensorData> processor() {
        return data -> {
            // Procesamiento de ejemplo
            data.setSensorValue(data.getSensorValue() * 1.05);
            return data;
        };
    }

    @Bean
    public JdbcBatchItemWriter<MarsSensorData> writer(DataSource dataSource) {
        JdbcBatchItemWriter<MarsSensorData> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO mars_sensor_data_processed (sensor_name, sensor_value, measurement_time) "
                + "VALUES (:sensorName, :sensorValue, :measurementTime)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }

    @Bean
    public Step marsDataStep(StepBuilderFactory sbf,
                             JdbcCursorItemReader<MarsSensorData> reader,
                             ItemProcessor<MarsSensorData, MarsSensorData> processor,
                             JdbcBatchItemWriter<MarsSensorData> writer) {
        return sbf.get("marsDataStep")
                .<MarsSensorData, MarsSensorData>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job marsDataJob(JobBuilderFactory jbf, Step marsDataStep) {
        return jbf.get("marsDataJob")
                .start(marsDataStep)
                .build();
    }
}

