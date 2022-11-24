<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Specifications</title>
    <script src="index-add.js" defer></script>
</head>
<body>
<fieldset id="new-speaker">
    <legend>Add</legend>
    Model<input type="text" name="model" value="SLR190X">
    <fieldset name="type" title="map-to-json-array">
        <legend>Type</legend>
        <input type="checkbox" name="2-way">2-way
        <input type="checkbox" name="3-way" checked>3-way
        <input type="checkbox" name="subwoofer">subwoofer
    </fieldset>
    <fieldset name="speaker">
        <legend>Speaker</legend>
        <fieldset name="subwoofer">
            <legend>Subwoofer</legend>
            Count<input type="number" name="count">&emsp;
            Diameter<input type="number" name="diameter"><label>inch</label>&emsp;
            Material<input type="text" name="material">
            <fieldset name="power">
                <legend>Power</legend>
                Peak<input type="number" name="peak"><label>W</label>&emsp;
                AES<input type="number" name="AES"><label>W</label>&emsp;
                EIA-RS-426A<input type="number" name="EIA-RS-426A"><label>W</label>&emsp;
                IEC-60268-5<input type="number" name="IEC-60268-5"><label>W</label>
            </fieldset>
            Sensitivity<input type="number" name="sensitivity"><label>dB/W@1m</label>&emsp;
            Impedance<input type="number" name="impedance"><label>Ω</label>
        </fieldset>
        <fieldset name="bass">
            <legend>Bass</legend>
            Count<input type="number" name="count" value="2">&emsp;
            Diameter<input type="number" name="diameter" value="15"><label>inch</label>&emsp;
            Material<input type="text" name="material">
            <fieldset name="power">
                <legend>Power</legend>
                Peak<input type="number" name="peak"><label>W</label>&emsp;
                AES<input type="number" name="AES"><label>W</label>&emsp;
                EIA-RS-426A<input type="number" name="EIA-RS-426A"><label>W</label>&emsp;
                IEC-60268-5<input type="number" name="IEC-60268-5" value="2000"><label>W</label>
            </fieldset>
            Sensitivity<input type="number" name="sensitivity" value="110"><label>dB/W@1m</label>&emsp;
            Impedance<input type="number" name="impedance" value="4"><label>Ω</label>
        </fieldset>
        <fieldset name="midrange">
            <legend>Midrange</legend>
            Count<input type="number" name="count" value="2">&emsp;
            Diameter<input type="number" name="diameter" value="8"><label>inch</label>&emsp;
            Material<input type="text" name="material">
            <fieldset name="power">
                <legend>Power</legend>
                Peak<input type="number" name="peak"><label>W</label>&emsp;
                AES<input type="number" name="AES"><label>W</label>&emsp;
                EIA-RS-426A<input type="number" name="EIA-RS-426A"><label>W</label>&emsp;
                IEC-60268-5<input type="number" name="IEC-60268-5" value="800"><label>W</label>
            </fieldset>
            Sensitivity<input type="number" name="sensitivity" value="111"><label>dB/W@1m</label>&emsp;
            Impedance<input type="number" name="impedance" value="4"><label>Ω</label>
        </fieldset>
        <fieldset name="treble">
            <legend>Treble</legend>
            Count<input type="number" name="count" value="4">&emsp;
            Diameter<input type="number" name="diameter" value="3"><label>inch</label>&emsp;
            Material<input type="text" name="material">
            <fieldset name="power">
                <legend>Power</legend>
                Peak<input type="number" name="peak"><label>W</label>&emsp;
                AES<input type="number" name="AES"><label>W</label>&emsp;
                EIA-RS-426A<input type="number" name="EIA-RS-426A"><label>W</label>&emsp;
                IEC-60268-5<input type="number" name="IEC-60268-5" value="400"><label>W</label>
            </fieldset>
            Sensitivity<input type="number" name="sensitivity" value="112"><label>dB/W@1m</label>&emsp;
            Impedance<input type="number" name="impedance" value="4"><label>Ω</label>
        </fieldset>
    </fieldset>
    <fieldset name="frequency_response">
        <legend>Frequency Response</legend>
        <input type="number" name="lbound" value="60"><label>Hz</label>
        ~ <input type="number" name="ubound" value="20"><label>kHz</label>&emsp;
        Variation<input type="text" name="variation" value="+/- 3 dB">
    </fieldset>
    <fieldset name="dimension">
        <legend>Dimension</legend>
        Width<input type="number" name="width"><label>mm</label>&emsp;
        Height<input type="number" name="height"><label>mm</label>&emsp;
        Depth<input type="number" name="depth"><label>mm</label>
    </fieldset>
    Weight<input type="number" name="weight" value="280"><label>kg</label>
    <br>
    <input id="add_button" type="button" value="Add">
</fieldset>
<fieldset>
    <legend>Query</legend>
    <label for="all-speakers"></label>
    <textarea id="all-speakers"></textarea>
</fieldset>
</body>
</html>