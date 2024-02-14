package in.co.mpwin.vigilencebilling.bean;

import in.co.mpwin.vigilencebilling.interfaces.BeanInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "LdfhBean")
@Table(name = "ldfh")
public class LdhfBean implements BeanInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="tariff")
    private String tariff;

    @Column(name="tariff_code")
    private String tariffCode;

    @Column(name="is_continuous")
    private String isContinuous;

    @Column(name="load_type")
    private String loadType;


    @Column(name="no_of_shift")
    private String noOfShift;


    @Column(name="days")
    private double days;

    @Column(name="months")
    private double months;

    @Column(name="hours")
    private double hours;

    @Column(name="factor_direct_theft")
    private String factorDirectTheft;

    @Column(name="factor_other")
    private String factorother;
    @Column(name="remark")
    private String remark;

   }
