#!/usr/bin/python2.7
# -*- coding: utf-8 -*-

import cairo

text = u"你"
print type(text)

text = text.encode('utf-8')


surface  = cairo.ImageSurface(cairo.FORMAT_A8, 40, 40);
cr = cairo.Context(surface);

face = cr.select_font_face("Noto Sans CJK KR", cairo.FONT_SLANT_NORMAL, cairo.FONT_WEIGHT_BOLD)


# cr.set_font_face(face)

# print face.get_family()

cr.set_font_size(32);

fascent, fdescent, fheight, fxadvance, fyadvance = cr.font_extents()
xbearing, ybearing, width, height, xadvance, yadvance = cr.text_extents(text)

yOffset = fascent;

cr.move_to(0, fascent)

print text

print type(text)
cr.show_text(text)
print fascent
print cairo.version
surface.write_to_png("./1.png");
