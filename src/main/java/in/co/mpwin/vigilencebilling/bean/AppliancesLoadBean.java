package in.co.mpwin.vigilencebilling.bean;

import in.co.mpwin.vigilencebilling.interfaces.BeanInterface;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "AppliancesLoadBean")
@Table(name = "appliances_load")
public class AppliancesLoadBean implements BeanInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="p4id")
    private String p4id;

    @Column(name="appliance_name")
    private String applianceName;

    @Column(name="appliance_load")
    private double applianceLoad;

    @Column(name="load_unit")
    private String loadUnit;

    @Column(name="no_of_appliance")
    private long noOfAppliance;

    @Column(name="tariff")
    private String tariff;
    @Column(name="load_type")
    private String loadType;

    @Column(name="remark")
    private String remark;

    @Column(name="created_by")
        private String createdBy;

    @Column(name="created_on")
    private Timestamp createdOn;
}
