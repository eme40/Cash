package com.eric.hello_cash.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SMS_Log")
@Entity
public class SmsLog extends BaseClass {
  private String phoneNumber;
  private String message;
  private String direction;
}
