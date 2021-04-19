package com.practice19.models.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@ManagedResource(
        objectName = "Practice22MBeans:category=MBeans,name=DataScheduler"
)
public class SheduleService {
    private final ItemsService itemsService;
    private final OrdersService ordersService;
    private final String path = "temp_dir";

    //every minute
    @Scheduled(cron = "0 * * * * *")
    @ManagedOperation(
            description = "Deletes all contents of the directory and " +
                    "writes all data from the database to it every 30 minutes"
    )
    public void start() throws IOException, NullPointerException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        log.info("SCHEDULED task started at {}", formatter.format(date));

        File dir = ResourceUtils.getFile(path);
        Arrays.stream(Objects.requireNonNull(dir.listFiles())).forEach(file -> {
            if (file.isFile()) {
                log.info("File " + file.getName() + " was deleted: " + file.delete());
            }
        });


        BufferedWriter iBufWriter = createWriter(path, "items.txt");;
        iBufWriter.write("id|name|creationDate|price\n");
        itemsService.getAll().forEach(item ->
        {
            try{
                iBufWriter.write(
                        String.format(
                                "%d|%s|%s|%f\n",
                                item.getId(),
                                item.getName(),
                                item.getCreation_date(),
                                item.getPrice()
                        )
                );
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        iBufWriter.close();

        BufferedWriter oBufWriter = createWriter(path, "orders.txt");
        oBufWriter.write("id|order_date\n");
        ordersService.getAll()
                .forEach(order -> {
                    try {
                        oBufWriter.write(
                                String.format(
                                        "%d|%s\n",
                                        order.getId(),
                                        order.getOrder_date())
                        );
                    }catch (IOException e) {
                        e.printStackTrace();
                    }

                });
        oBufWriter.close();
        log.info("SCHEDULED task finished.");
    }

    private BufferedWriter createWriter(String dir, String filename) throws IOException {
        return new BufferedWriter(new FileWriter(String.format("%s/%s", dir, filename)));
    }
}
