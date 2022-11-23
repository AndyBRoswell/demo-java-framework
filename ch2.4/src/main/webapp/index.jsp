<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Specifications</title>
</head>
<body>
<fieldset>
    <legend>Add</legend>
    <form>
        Model<input name="model">
        <fieldset name="type">
            <legend>Type</legend>
            <input type="checkbox" name="2-way">2-way
            <input type="checkbox" name="3-way">3-way
            <input type="checkbox" name="subwoofer">subwoofer
        </fieldset>
        <fieldset name="speaker">
            <legend>Speaker</legend>
            <fieldset name="subwoofer">
                <legend>Subwoofer</legend>
                Count<input type="number" name="count">
                Diameter<input type="number" name="diameter">inch
                Material<input type="text" name="material">
                <fieldset name="power">
                    <legend>Power</legend>
                    Peak<input type="number" name="peak">W
                    AES<input type="number" name="AES">W
                    EIA-RS-426A<input type="number" name="EIA-RS-426A">W
                    IEC-60268-5<input type="number" name="IEC-60268-5">W
                </fieldset>
                Sensitivity<input type="number" name="sensitivity">dB/W@1m
                Impedance<input type="number" name="impedance">Ω
            </fieldset>
            <fieldset name="bass">
                <legend>Bass</legend>
                Count<input type="number" name="count">
                Diameter<input type="number" name="diameter">inch
                Material<input type="text" name="material">
                <fieldset name="power">
                    <legend>Power</legend>
                    Peak<input type="number" name="peak">W
                    AES<input type="number" name="AES">W
                    EIA-RS-426A<input type="number" name="EIA-RS-426A">W
                    IEC-60268-5<input type="number" name="IEC-60268-5">W
                </fieldset>
                Sensitivity<input type="number" name="sensitivity">dB/W@1m
                Impedance<input type="number" name="impedance">Ω
            </fieldset>
            <fieldset name="midrange">
                <legend>Midrange</legend>
                Count<input type="number" name="count">
                Diameter<input type="number" name="diameter">inch
                Material<input type="text" name="material">
                <fieldset name="power">
                    <legend>Power</legend>
                    Peak<input type="number" name="peak">W
                    AES<input type="number" name="AES">W
                    EIA-RS-426A<input type="number" name="EIA-RS-426A">W
                    IEC-60268-5<input type="number" name="IEC-60268-5">W
                </fieldset>
                Sensitivity<input type="number" name="sensitivity">dB/W@1m
                Impedance<input type="number" name="impedance">Ω
            </fieldset>
            <fieldset name="treble">
                <legend>Treble</legend>
                Count<input type="number" name="count">
                Diameter<input type="number" name="diameter">inch
                Material<input type="text" name="material">
                <fieldset name="power">
                    <legend>Power</legend>
                    Peak<input type="number" name="peak">W
                    AES<input type="number" name="AES">W
                    EIA-RS-426A<input type="number" name="EIA-RS-426A">W
                    IEC-60268-5<input type="number" name="IEC-60268-5">W
                </fieldset>
                Sensitivity<input type="number" name="sensitivity">dB/W@1m
                Impedance<input type="number" name="impedance">Ω
            </fieldset>
        </fieldset>
        <fieldset>
            <legend>Dimension</legend>
            Width<input type="number" name="width">mm
            Height<input type="number" name="height">mm
            Depth<input type="number" name="depth">mm
        </fieldset>
        Weight<input type="number" name="weight">kg
        <br>
        <input type="submit" value="Add">
    </form>
</fieldset>
<fieldset>
    <legend>Query</legend>
    <label for="all-speakers"></label>
    <textarea id="all-speakers"></textarea>
</fieldset>
</body>
</html>