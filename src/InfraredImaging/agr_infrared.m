clc
close all

im1=imread('VIS.jpg');
im1=rgb2gray(im1);
im1=im2double(im1);

im2=imread('NIR.jpg');
im2=rgb2gray(im2);
im2=im2double(im2);

im_final=uint8(zeros([size(im2),3]));

im3=NDVI_func(im1,im2);
im_final=threshold(im3,im_final);

imwrite(im_final,'AgricultureInfrared.jpg');

