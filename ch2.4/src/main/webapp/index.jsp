<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Specifications</title>
    <script src="index-add.js" defer></script>
    <script src="index-list.js" defer></script>
</head>
<body>
<fieldset id="new-speaker">
    <legend>Add</legend>
    Model<input type="text" name="model" value="SLR190X">
    <fieldset name="type" title="map-to-json-array">
        <legend>Type</legend>
        <input type="checkbox" name="2-Way">2-Way
        <input type="checkbox" name="3-Way" checked>3-Way
        <input type="checkbox" name="Subwoofer">Subwoofer
    </fieldset>
    <fieldset name="driver">
        <legend>Driver</legend>
        <fieldset name="subwoofer">
            <legend>Subwoofer</legend>
            <label>Count</label><input type="number" name="count"><label></label>&emsp;
            <label>Diameter</label><input type="number" name="diameter"><label>inch</label>&emsp;
            <label>Material</label><input type="text" name="material"><label></label>
            <fieldset name="power">
                <legend>Power</legend>
                <label>Peak</label><input type="number" name="peak"><label>W</label>&emsp;
                <label>AES</label><input type="number" name="AES"><label>W</label>&emsp;
                <label>EIA-RS-426A</label><input type="number" name="EIA-RS-426A"><label>W</label>&emsp;
                <label>IEC-60268-5</label><input type="number" name="IEC-60268-5"><label>W</label>
            </fieldset>
            <label>Sensitivity</label><input type="number" name="sensitivity"><label>dB/W@1m</label>&emsp;
            <label>Impedance</label><input type="number" name="impedance"><label>Ω</label>
        </fieldset>
        <fieldset name="bass">
            <legend>Bass</legend>
            <label>Count</label><input type="number" name="count" value="2"><label></label>&emsp;
            <label>Diameter</label><input type="number" name="diameter" value="15"><label>inch</label>&emsp;
            <label>Material</label><input type="text" name="material"><label></label>
            <fieldset name="power">
                <legend>Power</legend>
                <label>Peak</label><input type="number" name="peak"><label>W</label>&emsp;
                <label>AES</label><input type="number" name="AES"><label>W</label>&emsp;
                <label>EIA-RS-426A</label><input type="number" name="EIA-RS-426A"><label>W</label>&emsp;
                <label>IEC-60268-5</label><input type="number" name="IEC-60268-5" value="2000"><label>W</label>
            </fieldset>
            <label>Sensitivity</label><input type="number" name="sensitivity" value="110"><label>dB/W@1m</label>&emsp;
            <label>Impedance</label><input type="number" name="impedance" value="4"><label>Ω</label>
        </fieldset>
        <fieldset name="midrange">
            <legend>Midrange</legend>
            <label>Count</label><input type="number" name="count" value="2"><label></label>&emsp;
            <label>Diameter</label><input type="number" name="diameter" value="8"><label>inch</label>&emsp;
            <label>Material</label><input type="text" name="material"><label></label>
            <fieldset name="power">
                <legend>Power</legend>
                <label>Peak</label><input type="number" name="peak"><label>W</label>&emsp;
                <label>AES</label><input type="number" name="AES"><label>W</label>&emsp;
                <label>EIA-RS-426A</label><input type="number" name="EIA-RS-426A"><label>W</label>&emsp;
                <label>IEC-60268-5</label><input type="number" name="IEC-60268-5" value="800"><label>W</label>
            </fieldset>
            <label>Sensitivity</label><input type="number" name="sensitivity" value="111"><label>dB/W@1m</label>&emsp;
            <label>Impedance</label><input type="number" name="impedance" value="4"><label>Ω</label>
        </fieldset>
        <fieldset name="treble">
            <legend>Treble</legend>
            <label>Count</label><input type="number" name="count" value="4"><label></label>&emsp;
            <label>Diameter</label><input type="number" name="diameter" value="3"><label>inch</label>&emsp;
            <label>Material</label><input type="text" name="material"><label></label>
            <fieldset name="power">
                <legend>Power</legend>
                <label>Peak</label><input type="number" name="peak"><label>W</label>&emsp;
                <label>AES</label><input type="number" name="AES"><label>W</label>&emsp;
                <label>EIA-RS-426A</label><input type="number" name="EIA-RS-426A"><label>W</label>&emsp;
                <label>IEC-60268-5</label><input type="number" name="IEC-60268-5" value="400"><label>W</label>
            </fieldset>
            <label>Sensitivity</label><input type="number" name="sensitivity" value="112"><label>dB/W@1m</label>&emsp;
            <label>Impedance</label><input type="number" name="impedance" value="4"><label>Ω</label>
        </fieldset>
    </fieldset>
    <fieldset name="frequency_response">
        <legend>Frequency Response</legend>
        <input type="number" name="lbound" value="60"><label>Hz</label>
        <label>~ </label><input type="number" name="ubound" value="20"><label>kHz</label>&emsp;
        <label>Variation</label><input type="text" name="variation" value="+/- 3 dB"><label></label>
    </fieldset>
    <fieldset name="dimension">
        <legend>Dimension</legend>
        <label>Width</label><input type="number" name="width"><label>mm</label>&emsp;
        <label>Height</label><input type="number" name="height"><label>mm</label>&emsp;
        <label>Depth</label><input type="number" name="depth"><label>mm</label>
    </fieldset>
    <label>Weight</label><input type="number" name="weight" value="280"><label>kg</label>
    <br>
    <input id="add_button" type="button" value="Add">
</fieldset>
<fieldset>
    <legend>Query</legend>
    <input id="list_button" type="button" value="List all speakers">
    <label for="all-speakers"></label>
    <textarea id="all-speakers"></textarea>
</fieldset>
</body>
</html>