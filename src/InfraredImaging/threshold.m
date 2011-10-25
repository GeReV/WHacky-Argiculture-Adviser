function im_m=threshold(im3,im_final)
[length_x,length_y,length_z]=size(im_final);
for i=1:length_x
    for j=1:length_y
            if(im3(i,j)>0.5)
                im_final(i,j,1)=0;
                im_final(i,j,2)=75;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<0.5 & im3(i,j)>0.4)
                im_final(i,j,1)=0;
                im_final(i,j,2)=120;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<0.4 & im3(i,j)>0.3)
                im_final(i,j,1)=50;
                im_final(i,j,2)=150;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<0.3 & im3(i,j)>0.2)
                im_final(i,j,1)=120;
                im_final(i,j,2)=200;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<0.2 & im3(i,j)>0.1)
                im_final(i,j,1)=200;
                im_final(i,j,2)=255;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<0.1 & im3(i,j)>0.0)
                im_final(i,j,1)=255;
                im_final(i,j,2)=255;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<0.0 & im3(i,j)>-0.1)
                im_final(i,j,1)=255;
                im_final(i,j,2)=255;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<-0.1 & im3(i,j)>-0.2)
                im_final(i,j,1)=255;
                im_final(i,j,2)=200;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<-0.2 & im3(i,j)>-0.3)
                im_final(i,j,1)=220;
                im_final(i,j,2)=130;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<-0.3 & im3(i,j)>-0.4)
                im_final(i,j,1)=170;
                im_final(i,j,2)=75;
                im_final(i,j,3)=0;
            elseif(im3(i,j)<-0.4 & im3(i,j)>-0.5)
                im_final(i,j,1)=100;
                im_final(i,j,2)=20;
                im_final(i,j,3)=0;
            else
                im_final(i,j,1)=64;
                im_final(i,j,2)=20;
                im_final(i,j,3)=0;
            end
    end
end
im_m=im_final;
end