import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by hzeng on 6/26/14.
 */

enum Unit {
    M("m", 1000),
    CM("cm", 10),
    MM("mm", 1);

    private String des;
    private double value;
    private Unit(String des, double value1) {
        this.des = des;
        this.value = value1;
    }

    public double getUnit() {
        return this.value;
    }

    public String getDes() {
        return this.des;
    }

    public int compare(Unit unit1) {
        double diff =  this.getUnit() - unit1.getUnit();
        if (diff > 0) {
            return 1;
        }
        else if (diff == 0) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public double transFactorToUnit(Unit unit1) { return this.value / unit1.value; }
}

public class Length {
    private double value;
    private Unit unit;

    private  Length(double value) {
        this.value = value;
        this.unit = Unit.MM;
    }
    private Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }
    private double getTransedValueToUnit(Unit unit1) {
        return this.value * this.unit.transFactorToUnit(unit1);
    }

    public double getValue() { return  this.value; }
    public String getUnit() { return this.unit.getDes(); }

    public static Length getLength(double value, Unit unit) { return new Length(value, unit);}

    public Length add(Length len) {
        if (this.unit.compare(len.unit) == 0) {
            return new Length(this.value + len.value, this.unit);
        }
        else if (this.unit.compare(len.unit) > 0) {
            return new Length(this.getTransedValueToUnit(len.unit) + len.value, len.unit);
        }
        else {
            return new Length(this.value + len.getTransedValueToUnit(this.unit), this.unit);
        }
    }

    public Length subtract(Length len) {
        if (this.unit.compare(len.unit) == 0) {
            return new Length(this.value - len.value, this.unit);
        }
        else if (this.unit.compare(len.unit) > 0) {
            return new Length(this.getTransedValueToUnit(len.unit) - len.value, len.unit);
        }
        else {
            return new Length(this.value - len.getTransedValueToUnit(this.unit), this.unit);
        }
    }
    public Length multiply(double par1) {
        return new Length(this.value * par1, this.unit);
    }
    public Length divide(double par1) {
        return new Length(this.value / par1, this.unit);
    }

    @Override
    public String toString() {
        String priStr = "Length{\n      ";
        priStr += (this.value + this.getUnit() + "(original)\n");
        for (Unit unit1:Unit.values()) {
            if (this.unit.compare(unit1) != 0) {
                priStr += ("     =" + this.getTransedValueToUnit(unit1) + unit1.getDes() + "\n");
            }
        }
        priStr += "}";
        return priStr;
    }
}


