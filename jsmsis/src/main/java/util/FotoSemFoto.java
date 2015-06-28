/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author MOISES
 */
public class FotoSemFoto {

    public static final String TYPE = "image/jpg";
    public static final String ENCODE = "/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABGAAD/4QMpaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjAtYzA2MCA2MS4xMzQ3NzcsIDIwMTAvMDIvMTItMTc6MzI6MDAgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDUzUgV2luZG93cyIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo0MzAzNEYzRTQyQzcxMUUxOTg2RDk3MTg0MDcyNDg5QyIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDo0MzAzNEYzRjQyQzcxMUUxOTg2RDk3MTg0MDcyNDg5QyI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjQzMDM0RjNDNDJDNzExRTE5ODZEOTcxODQwNzI0ODlDIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjQzMDM0RjNENDJDNzExRTE5ODZEOTcxODQwNzI0ODlDIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+/+4AJkFkb2JlAGTAAAAAAQMAFQQDBgoNAAAPaQAAFz8AACLuAAAvcf/b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";
    public static final String NOME = "SEM FOTO";
    public static final Long SIZE = 1l;
}