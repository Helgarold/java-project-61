<?xml version="1.0"?>
<!DOCTYPE Module PUBLIC
        "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN"
        "https://checkstyle.org/dtds/configuration_1_3.dtd">

<Module name="Checker">
    <Module name="TreeWalker">
        <!-- Проверка имен классов (например, UpperCamelCase) -->
        <Module name="WhitespaceAround">
            <Property name="tokens" value="ASSIGN, PLUS, MINUS, MULT, DIV, BITWISE_AND, BITWISE_OR, BITWISE_XOR" />
        </Module>

        <!-- Проверка отступов (например, 4 пробела) -->
        <Module name="Indentation">
            <Property name="tabWidth" value="4" />
            <Property name="ignorePattern" value="^\\s*$" />
        </Module>

        <!-- Проверка длины строки (например, не более 120 символов) -->
        <Module name="LineLength">
            <Property name="max" value="120" />
        </Module>

        <!-- Проверка на пустые строки -->
        <Module name="EmptyLineSeparator">
            <Property name="file" value="true" />
        </Module>

        <!-- Проверка комментариев (например, наличие Javadoc) -->
        <Module name="JavadocType">
            <Property name="scope" value="public" />
            <Property name="allowMissing" value="false" />
        </Module>

        <!-- Проверка на использование логики -->
        <Module name="AvoidStarImport" />

        <!-- Проверка на неиспользуемые импорты -->
        <Module name="UnusedImports" />
    </Module>
</Module>