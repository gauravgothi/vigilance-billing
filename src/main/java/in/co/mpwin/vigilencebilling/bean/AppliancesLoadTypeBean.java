package in.co.mpwin.vigilencebilling.bean;

import in.co.mpwin.vigilencebilling.interfaces.BeanInterface;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "AppliancesLoadTypeBean")
@Table(name = "appliances_load_type", schema = "vigilance",uniqueConstraints = @UniqueConstraint(name = "appliances_load_type_ukey",columnNames = {"appliance_name","tariff_code","load_type"}))
public class AppliancesLoadTypeBean implements BeanInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appliance_code")
    private String applianceCode;

    @Column(name = "appliance_name")
    private String applianceName;

    @Column(name = "tariff")
    private String tariff;

    @Column(name = "tariff_code")
    private String tariffCode;

    @Column(name = "load_type")
    private String loadType;

    @Column(name = "remark")
    private String remark;

}
